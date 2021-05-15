package com.example.zipcarrentalapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Booking_History extends AppCompatActivity {
    private static final String PREFERENCE_NAME = "SAMPLE-SP";
    private SharedPreferences prefs;
    private String TAG ="PHUONG";
    private TextView tv_details ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_history);

        this.prefs = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

        String Booking_Code = this.prefs.getString("booking_code","");
        String License_Plate = this.prefs.getString("license_plate","");
        String Total = this.prefs.getString("total","");

        tv_details = (TextView) findViewById(R.id.tv_booking_history);
        tv_details.setText("Booking Code: "+Booking_Code+"\n"+
                            "License Plate: "+License_Plate+"\n"+
                            "Cost: "+Total);
    }

    public void Delete_History(View view){
        this.prefs.edit().clear().commit();
        Toast.makeText(this.getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Deleted");
    }

    public void New_Booking(View view){
        Intent move = new Intent(this,MainActivity.class);
        startActivity(move);
    }

}
