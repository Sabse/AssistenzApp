package com.uni_r.sabrina.assistapp.main;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.uni_r.sabrina.assistapp.overview.OverviewActivity;
import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.responseless.ResponselessActivity;

/**
 * This class provides the start screen with 5 buttons and the emergency call footer
 * It gives a first insight about the apps content to the user and helps to orientate between the different topics
 */
public class MainActivity extends EmergencyCallActivity {

    RelativeLayout relativeLayout;
    ImageView responslessButton;
    ImageView injuryButton;
    ImageView stomachButton;
    ImageView chestButton;
    ImageView headButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    private void setupButtons() {
        // setup position for buttons in startscreen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int sb = size.x;
        int sh = size.y;

        // setup position for responsless button
        int responslessButtonSize = (int) (sb*0.45f);
        int responslessButtonMarginLeft =(int) (sb*0.274);
        int responslessButtonMarginTop =(int) (sh*0.233);

        // setup position for buttons around the responsless button
        int sideButtonWidth = (int) (sb*0.639f);
        int sideButtonHeight = (int) (sideButtonWidth*0.435f);
        int sideButtonHorizontalMarginLeft = (int) (sb*0.18); //
        int sideButtonVerticalMarginTop = (int) (sh*0.175);

        // setup specific position for buttons around responsless button
        int injuryButtonMarginTop = (int) (sh*0.085);
        int chestButtonMarginTop = (int) (sh*0.487);
        int stomachButtonMarginLeft = (int) (sb*0.695);
        int headButtonMarginLeft = (int) (sb*0.025);

        relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);

        //Setup responsless button
        responslessButton = (ImageView) findViewById(R.id.responseless_button);
        RelativeLayout.LayoutParams responslessButtonLayoutParams = new RelativeLayout.LayoutParams(responslessButtonSize, responslessButtonSize);
        responslessButtonLayoutParams.setMargins(responslessButtonMarginLeft, responslessButtonMarginTop, 0, 0);
        responslessButton.setLayoutParams(responslessButtonLayoutParams);

        //Setup injury button
        injuryButton = (ImageView) findViewById(R.id.injury_button);
        RelativeLayout.LayoutParams injuryButtonLayoutParams = new RelativeLayout.LayoutParams(sideButtonWidth, sideButtonHeight);
        injuryButtonLayoutParams.setMargins(sideButtonHorizontalMarginLeft, injuryButtonMarginTop, 0, 0);
        injuryButton.setLayoutParams(injuryButtonLayoutParams);

        //Setup stomach button
        stomachButton = (ImageView) findViewById(R.id.stomach_button);
        RelativeLayout.LayoutParams stomachButtonLayoutParams = new RelativeLayout.LayoutParams(sideButtonHeight, sideButtonWidth);
        stomachButtonLayoutParams.setMargins(stomachButtonMarginLeft, sideButtonVerticalMarginTop, 0, 0);
        stomachButton.setLayoutParams(stomachButtonLayoutParams);

        //Setup chest button
        chestButton = (ImageView) findViewById(R.id.chest_button);
        RelativeLayout.LayoutParams chestButtonLayoutParams = new RelativeLayout.LayoutParams(sideButtonWidth, sideButtonHeight);
        chestButtonLayoutParams.setMargins(sideButtonHorizontalMarginLeft, chestButtonMarginTop, 0, 0);
        chestButton.setLayoutParams(chestButtonLayoutParams);

        //Setup head button
        headButton = (ImageView) findViewById(R.id.head_button);
        RelativeLayout.LayoutParams headButtonLayoutParams = new RelativeLayout.LayoutParams(sideButtonHeight, sideButtonWidth);
        headButtonLayoutParams.setMargins(headButtonMarginLeft, sideButtonVerticalMarginTop, 0, 0);
        headButton.setLayoutParams(headButtonLayoutParams);
    }

    public void startResponselessActivity(View v){
        // start responsless activity when responsless button touched
        Intent intent = new Intent(MainActivity.this, ResponselessActivity.class);
        startActivity(intent);
    }

    public void startOverviewActivity(View v){
        // start overview activity and show fragment depending to the touched button
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
