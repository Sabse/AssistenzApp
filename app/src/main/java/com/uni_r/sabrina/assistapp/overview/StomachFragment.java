package com.uni_r.sabrina.assistapp.overview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.uni_r.sabrina.assistapp.R;

/**
 * Created by Sabse on 24.05.2015.
 * This class manages the visibility of topic related content within the expandable list.
 */
public class StomachFragment extends Fragment{

    RelativeLayout content1;
    RelativeLayout content2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_stomach,container,false);

        content1 = (RelativeLayout) v.findViewById(R.id.stomach_title_1_content);
        content1.setVisibility(View.GONE);

        content2 = (RelativeLayout) v.findViewById(R.id.stomach_title_2_content);
        content2.setVisibility(View.GONE);

        return v;
    }
}
