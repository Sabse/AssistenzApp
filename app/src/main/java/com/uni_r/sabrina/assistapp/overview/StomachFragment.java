package com.uni_r.sabrina.assistapp.overview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni_r.sabrina.assistapp.R;

/**
 * Created by Sabse on 24.05.2015.
 */
public class StomachFragment extends Fragment{

    TextView content1;
    TextView content2;
    TextView content3;
    TextView content4;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_stomach,container,false);

        content1 = (TextView) v.findViewById(R.id.stomach_title_1_content);
        content1.setVisibility(View.GONE);

        content2 = (TextView) v.findViewById(R.id.stomach_title_2_content);
        content2.setVisibility(View.GONE);

        content3 = (TextView) v.findViewById(R.id.stomach_title_3_content);
        content3.setVisibility(View.GONE);

        content4 = (TextView) v.findViewById(R.id.stomach_title_4_content);
        content4.setVisibility(View.GONE);

        return v;
    }
}
