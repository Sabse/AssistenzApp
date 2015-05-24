package com.uni_r.sabrina.assistapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.uni_r.sabrina.assistapp.overview.OverviewActivity;
import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.responseless.ResponselessActivity;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
