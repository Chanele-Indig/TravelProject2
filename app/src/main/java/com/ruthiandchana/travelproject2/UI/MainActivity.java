package com.ruthiandchana.travelproject2.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.fragment.app.Fragment;


import com.ruthiandchana.travelproject2.Entities.Travel;
import com.ruthiandchana.travelproject2.Entities.UserLocation;
import com.ruthiandchana.travelproject2.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Firebase";
    MainViewModel travelViewModel;
    String travelDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // travelViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        travelViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        travelViewModel.getIsSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean t) {
                if (t)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });

        final Fragment first = new FirstFragment();
        final Fragment second = new SecondFragment();

        findViewById(R.id.fragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.layout, first);
                fragmentTransaction.commit();
            }
        });

        findViewById(R.id.fragment2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.layout, second);
                fragmentTransaction.commit();
            }
        });


        //Insert Travels
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            travelDate = format.format(new Date());
            travelDate = "20" + "/" + "09" + "/" + "2020";
            Date tDate = new Travel.DateConverter().fromTimestamp(travelDate);
            if (tDate == null)
                throw new Exception("שגיאה בתאריך");

            Travel travel1 = new Travel();
            travel1.setClientName("Jony");
            travel1.setClientPhone("026456677");
            travel1.setClientEmail("Yossi05489@gmail.com");
            travel1.setTravelLocation(new UserLocation(10.0, 20.0));
            travel1.setTravelDate(tDate);
            travel1.setArrivalDate(tDate);
            travel1.setRequesType(Travel.RequestType.sent);
            travel1.setCompany(new HashMap<String, Boolean>());
            travel1.getCompany().put("Afikim",Boolean.FALSE);
            travel1.getCompany().put("SuperBus",Boolean.FALSE);
            travel1.getCompany().put("SmartBus",Boolean.FALSE);
            travel1.getCompany().put("SmartBus",Boolean.TRUE);
            travelViewModel.addTravel(travel1);

            Travel travel2 = new Travel();
            travel2.setClientName("Ronit");
            travel2.setClientPhone("026334512");
            travel2.setClientEmail("RonitMarxs@gmail.com");
            travel2.setTravelLocation(new UserLocation(15.0, 25.0));
            travel2.setTravelDate(tDate);
            travel2.setArrivalDate(tDate);
            travel2.setRequesType(Travel.RequestType.sent);
            travel2.setCompany(new HashMap<String, Boolean>());
            travel2.getCompany().put("Egged",Boolean.FALSE);
            travel2.getCompany().put("TsirTour",Boolean.FALSE);

            travelViewModel.addTravel(travel2);

            travel2.setClientName("Bluma");
            travelViewModel.updateTravel(travel2);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}