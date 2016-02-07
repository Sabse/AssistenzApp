package com.uni_r.sabrina.assistapp.responseless;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uni_r.sabrina.assistapp.R;

/**
 * Created by Sabse on 24.05.2015.
 * This class contains the fragment to gain informations about not responding but breathing persons
 */
public class BreathActiveFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_breath_active,container,false);
        return v;
    }
}
