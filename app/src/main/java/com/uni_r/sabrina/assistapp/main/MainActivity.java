package com.uni_r.sabrina.assistapp.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.uni_r.sabrina.assistapp.overview.OverviewActivity;
import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.responseless.ResponselessActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    String locationProvider;
    String personalLocation = "";
    LocationManager locationManager;
    LocationListener locationListener;
    Location location;
    Geocoder gcd;

    List<Address> addresses = new ArrayList<Address>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationListener = new LocationListener();
        locationProvider  = LocationManager.GPS_PROVIDER;
        gcd = new Geocoder(this, Locale.getDefault());


        locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            //falls GPS nicht enabled hier anbieten es anzuschalten
        }
        else{
        }
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, 10, locationListener);
        location = locationManager.getLastKnownLocation(locationProvider);
        try {
            addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if(addresses != null && addresses.size() > 0){
                Address address = addresses.get(0);
                personalLocation += address.getAddressLine(0) + " in " + address.getAddressLine(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void startResponselessActivity(View v){
        Intent intent = new Intent(MainActivity.this, ResponselessActivity.class);
        startActivity(intent);
    }

    public void startOverviewActivity(View v){
        Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
        switch(v.getTag().toString()){
            case "injuryButton": intent.putExtra("ButtonValue", 0);
                break;
            case "headButton": intent.putExtra("ButtonValue", 1);
                break;
            case "chestButton": intent.putExtra("ButtonValue", 2);
                break;
            case "stomachButton": intent.putExtra("ButtonValue", 3);
                break;
            default: Log.d("Main Activity: ", "Failed identifying button!");
                break;
        }

        startActivity(intent);
    }

    public void emergencyCall(View v){
        new AlertDialog.Builder(this)
                .setTitle("Jetzt Notruf wählen?")
                .setMessage("Sie befinden sich hier: " + personalLocation)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "112"));
                        startActivity(intent);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
