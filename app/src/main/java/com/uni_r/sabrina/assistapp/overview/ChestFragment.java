package com.uni_r.sabrina.assistapp.overview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uni_r.sabrina.assistapp.R;

/**
 * Created by Sabse on 24.05.2015.
 */
public class ChestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_chest,container,false);
        return v;
    }
}
