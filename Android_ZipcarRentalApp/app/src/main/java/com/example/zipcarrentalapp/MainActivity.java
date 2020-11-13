package com.example.zipcarrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.zipcarrentalapp.Models.Order;
import com.example.zipcarrentalapp.Models.ZipCar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    static final String PREFERENCE_NAME="SAMPLE-SP";
    private final String TAG="PHUONG";
    ArrayList<Integer> hireTimeList;
    ArrayList<String> hireTimeSList;
    CheckBox cb_outsideZone;
    EditText et_outsideZone;
    EditText et_customerName;
    RadioGroup rg_carType;
    RadioButton rb_selectedBtn;
    Spinner spHireTime;
    int outsideZone = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if saved data exist!
        this.prefs = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        String Booking_Code = this.prefs.getString("booking_code",""); //second param is default value
        if (!Booking_Code.isEmpty()){
            Intent move = new Intent(this,Booking_History.class);
            startActivity(move);
        }



        hireTimeSList = new ArrayList<>();
        hireTimeList = ZipCarUtils.loadHireTime();
        for(Integer hire:hireTimeList){
            if (hire==24)
                hireTimeSList.add("All day");
            else
                hireTimeSList.add(hire.toString()+" hr(s)");
        }

        spHireTime = (Spinner) findViewById(R.id.sp_rentalHours);
        ArrayAdapter<String> carNameAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,hireTimeSList);
        spHireTime.setAdapter(carNameAdapter);


        cb_outsideZone = (CheckBox) findViewById(R.id.cb_outsideZone);
        et_outsideZone = (EditText) findViewById(R.id.et_outsideZone);
        cb_outsideZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_outsideZone.isChecked()){
                    et_outsideZone.setVisibility(View.VISIBLE);
                }
                else{
                    et_outsideZone.setVisibility(View.INVISIBLE);
                    et_outsideZone.setText(""); //erase when uncheck
                }
            }
        });


    }

    public void Book_Car(View view){
        //Get Car Type
        rg_carType = (RadioGroup) findViewById(R.id.rgCarType);
        int rbtn_ID = rg_carType.getCheckedRadioButtonId();
        rb_selectedBtn = (RadioButton) rg_carType.findViewById(rbtn_ID);
        String carType = (String) rb_selectedBtn.getText();
        Log.d(TAG,carType);

        //Get customer name
        et_customerName = (EditText) findViewById(R.id.etName);
        String customerName = et_customerName.getText().toString();

        //Get hire time
        spHireTime = (Spinner) findViewById(R.id.sp_rentalHours);
        String temp = spHireTime.getSelectedItem().toString();
        int hireTime = 0;
        for(int i=0;i<hireTimeSList.size();i++){
            if (temp.equals(hireTimeSList.get(i)))
                hireTime = hireTimeList.get(i);
        }
        Log.d(TAG,"Hire Time: "+Integer.toString(hireTime));


        //Get outsideZone
        et_outsideZone = (EditText) findViewById(R.id.et_outsideZone);
        String temp2 = et_outsideZone.getText().toString();
        if (temp2.equals(""))
            outsideZone = 0;
        else
            outsideZone = Integer.parseInt(temp2);

        Order customer_order = new Order(customerName,carType,hireTime,outsideZone);
        Intent move = new Intent(this,ReceiptActivity.class);
        move.putExtra("order",customer_order);
        startActivity(move);
    }
}