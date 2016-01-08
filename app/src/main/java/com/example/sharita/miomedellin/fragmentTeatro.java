package com.example.sharita.miomedellin;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sharita on 03/11/2015.
 */
public class fragmentTeatro extends Fragment {
    protected TextView customFont;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_teatro, container, false);
        customFont= (TextView) v.findViewById(R.id.fuente);
        Typeface font= Typeface.createFromAsset(getActivity().getAssets(), "gloriahallelujah.ttf");
        customFont.setTypeface(font);


        return v;
    }
}