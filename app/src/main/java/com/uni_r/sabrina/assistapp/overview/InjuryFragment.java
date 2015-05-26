package com.uni_r.sabrina.assistapp.overview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.uni_r.sabrina.assistapp.R;

import org.w3c.dom.Text;

/**
 * Created by Sabse on 24.05.2015.
 */
public class InjuryFragment extends Fragment{

    TextView content1;
    TextView content2;
    TextView content3;
    TextView content4;
    TextView content5;
    TextView content6;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_injury,container,false);

        content1 = (TextView) v.findViewById(R.id.injury_title_1_content);
        content1.setVisibility(View.GONE);

        content2 = (TextView) v.findViewById(R.id.injury_title_2_content);
        content2.setVisibility(View.GONE);

        content3 = (TextView) v.findViewById(R.id.injury_title_3_content);
        content3.setVisibility(View.GONE);

        content4 = (TextView) v.findViewById(R.id.injury_title_4_content);
        content4.setVisibility(View.GONE);

        content5 = (TextView) v.findViewById(R.id.injury_title_5_content);
        content5.setVisibility(View.GONE);

        content6 = (TextView) v.findViewById(R.id.injury_title_6_content);
        content6.setVisibility(View.GONE);

        return v;


    }





}
