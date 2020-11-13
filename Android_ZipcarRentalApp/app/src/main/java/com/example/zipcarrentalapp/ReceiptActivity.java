package com.example.zipcarrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zipcarrentalapp.Models.Order;
import com.example.zipcarrentalapp.Models.ZipCar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class ReceiptActivity extends AppCompatActivity {
    private final String TAG = "PHUONG";
    ArrayList<ZipCar> SUV_Cars ;
    ArrayList<ZipCar> Sedan_Cars;
    ZipCar picked_Car;
    ImageView img_Car;
    TextView tv_CarSummary;
    TextView tv_RentalSummary;
    Double Total;
    String Booking_Code;
    SharedPreferences pref;
    static final String PREFERENCE_NAME = "SAMPLE-SP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        pref = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

        SUV_Cars = ZipCarUtils.loadSUVZipCars();
        Sedan_Cars = ZipCarUtils.loadSEDANZipCars();


        Intent data = this.getIntent();
        Order cusomter_order = (Order) data.getSerializableExtra("order");
        Log.d(TAG,"order: "+cusomter_order.toString());

        TextView tv_Name = (TextView) findViewById(R.id.tv_Name);
        tv_Name.setText("Rental Confirmation of "+cusomter_order.getCustomerName());


        if (cusomter_order.getCarName().toLowerCase().contains("suv")){
            Random rn = new Random();
            int randNumb = rn.nextInt(SUV_Cars.size()) + 0;
            picked_Car = SUV_Cars.get(randNumb);
        }

        if (cusomter_order.getCarName().toLowerCase().contains("sedan")){
            Random rn = new Random();
            int randNumb = rn.nextInt(Sedan_Cars.size()) + 0;
            picked_Car = Sedan_Cars.get(randNumb);
        }

        img_Car = (ImageView) findViewById(R.id.img_Car);
        int id =getResources()
                .getIdentifier(
                        picked_Car.getImage(),      // gets the picture file name frm the object
                        "drawable",
                        getPackageName()
                );
        img_Car.setImageResource(id);


        Car_Summary(picked_Car);
        Rental_Summary(picked_Car,cusomter_order);
    }


    public void Car_Summary(ZipCar car){
        tv_CarSummary = (TextView) findViewById(R.id.tv_CarSummary);
        tv_CarSummary.setText(car.getColor()+" "+ car.getMake()+" "+car.getModel()+" "+car.getLicence_Plate()+"\n"+
                car.getLocation());
    }


    public void Rental_Summary(ZipCar car, Order order){
        tv_RentalSummary = (TextView) findViewById(R.id.tv_RentalSummary);
        String outsidezone_string = "";
        Double subtotal = 0.0;

        if (car.getType().toLowerCase().equals("sedan")) {
            if (order.getHireTime() == 24)
                subtotal = 106 * (order.getOutsideZoneDistance() * 0.5);
            else
                subtotal = (14.0 * order.getHireTime() + (order.getOutsideZoneDistance() * 0.5));
        }

        if (car.getType().toLowerCase().equals("suv")) {
            if (order.getHireTime() == 24)
                subtotal = 172 * (order.getOutsideZoneDistance() * 0.5);
            else
                subtotal = (22.0 * order.getHireTime() + (order.getOutsideZoneDistance() * 0.5));
        }


        if (order.getOutsideZoneDistance()==0)
            outsidezone_string = "within zone";
        else
            outsidezone_string = Integer.toString(order.getOutsideZoneDistance()) +"km(s)";

        Double tax = subtotal*0.13;
        Total = tax+subtotal;
        tv_RentalSummary.setText(car.getType()+" "+Integer.toString(order.getHireTime())+" hour(s)"+" "+ outsidezone_string+"\n"+
                "Subtotal: "+Double.toString(subtotal)+"\n"+
                "Tax: "+ Double.toString(tax)+"\n"+
                "Total: "+ Double.toString(Total)
        );
    }

    public static String generateRandomCode() {
        final String alphabet = "0123456789ABCDEF";
        final int N = alphabet.length();

        Random r = new Random();

        String code = "";

        for (int i = 0; i < 5; i++) {
            code += alphabet.charAt(r.nextInt(N));
        }
        return code;
    }

    public void Confirm(View view){
        //Saving
        SharedPreferences.Editor prefEditor = this.pref.edit();
        Booking_Code = generateRandomCode();
        prefEditor.putString("booking_code",Booking_Code);
        prefEditor.putString("license_plate",picked_Car.getLicence_Plate());
        prefEditor.putString("total",Total.toString());
        prefEditor.apply();
        Log.d(TAG,"Saved");
        Intent move = new Intent(this,Booking_History.class);
        startActivity(move);
    }

    public void Go_Back(View view){
        Intent move = new Intent(this,MainActivity.class);
        startActivity(move);
    }
}