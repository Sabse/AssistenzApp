package com.uni_r.sabrina.assistapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.uni_r.sabrina.assistapp.R;

/**
 * Created by Sabse on 01.06.2015.
 * This class represents the activity that contains everything about self protection
 * It is what the app starts with
 */
public class MainPopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
    }

    public void startApp(View v){
        // if user touches button
        Intent intent = new Intent(MainPopUpActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
