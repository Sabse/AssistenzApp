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
import android.view.View;
import android.widget.TextView;
import com.uni_r.sabrina.assistapp.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sabse on 30.10.2015.
 * This Class handles the logic behind the emergency call button (gps localisation, alert content, linking to telephone app).
 * It is set up as footer and can be embedded into any activity.
 * If so the activity will show the emergeny button located on the bottom.
 */
public abstract class EmergencyCallActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_emergency_call);
        locationListener = new LocationListener();
        locationProvider  = LocationManager.GPS_PROVIDER;
        gcd = new Geocoder(this, Locale.getDefault());
        locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //check status of GPS Provider
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            //in case the GPS provider is disabled, return feedback to user and ask for permission (not implemented!)
        }
        else{
        }
        //Request for updates and get last known location
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, 10, locationListener);
        location = locationManager.getLastKnownLocation(locationProvider);
        //try converting longitude and latitude data to full address
        try {
            if(location != null) {
                addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            }
            if(addresses != null && addresses.size() > 0){
                Address address = addresses.get(0);
                personalLocation += address.getAddressLine(0) + " in " + address.getAddressLine(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //called if emergency button pressed
    public void emergencyCall(View v){
        //setup alert dialog
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Jetzt Notruf wählen?")
                .setMessage("Sie befinden sich hier:\n" + personalLocation)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //call phone app and setup number
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "112"));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing and return to activity
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextAppearance(getApplicationContext(), R.style.RobotoTextViewStyle);
    }
}
