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
public class HeadFragment extends Fragment {

    TextView content1;
    TextView content2;
    TextView content3;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_head,container,false);

        content1 = (TextView) v.findViewById(R.id.head_title_1_content);
        content1.setVisibility(View.GONE);

        content2 = (TextView) v.findViewById(R.id.head_title_2_content);
        content2.setVisibility(View.GONE);

        content3 = (TextView) v.findViewById(R.id.head_title_3_content);
        content3.setVisibility(View.GONE);

        return v;
    }
}
