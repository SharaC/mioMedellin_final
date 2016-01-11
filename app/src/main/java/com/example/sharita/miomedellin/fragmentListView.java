package com.example.sharita.miomedellin;

/**
 * Created by Sharita on 02/11/2015.
 */
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class fragmentListView extends ListFragment {



    private ListView listView;
    String prueba;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //return super.onCreateView(inflater, container, savedInstanceState);
        Toast.makeText(getActivity(),"esto no deberia verse",Toast.LENGTH_LONG);

        return inflater.inflate(R.layout.fragment_list_view, container, false);


    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        // Toast.makeText(getActivity(), "Usted ha pulsado " + item[position],
        //       Toast.LENGTH_SHORT).show();

        showDetails(position);


    }

    void showDetails(int index) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        boolean pantalla = getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE);
        int orient= getResources().getConfiguration().orientation;


        if (pantalla ) {

            prueba= "es tablet 9 pulgadas";

            switch (index) {

                case 0:

                    fragmentComida fComida = new fragmentComida();
                    fragmentTransaction.replace(R.id.fragmentDetail, fComida);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

                case 1:

                    fragmentCines fCines = new fragmentCines();
                    fragmentTransaction.replace(R.id.fragmentDetail, fCines);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 2:
                    fragmentTeatro fTeatro = new fragmentTeatro();
                    fragmentTransaction.replace(R.id.fragmentDetail, fTeatro);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 3:

                    fragmentSitios fSitios = new fragmentSitios();
                    fragmentTransaction.replace(R.id.fragmentDetail, fSitios);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 4:

                    fragmentRumba fRumba = new fragmentRumba();
                    fragmentTransaction.replace(R.id.fragmentDetail, fRumba);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

            }


        } else {
            prueba= "no es tablet";
            fragmentDetalle fdetalle =new fragmentDetalle();
            switch (index) {
                case 0:
                    fragmentComida fComida = new fragmentComida();
                    fragmentTransaction.replace(android.R.id.content, fComida);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 1:

                    fragmentCines fCines = new fragmentCines();
                    fragmentTransaction.replace(android.R.id.content, fCines);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 2:
                    fragmentTeatro fTeatro = new fragmentTeatro();
                    fragmentTransaction.replace(android.R.id.content, fTeatro);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 3:
                    fragmentSitios fSitios = new fragmentSitios();
                    fragmentTransaction.replace(android.R.id.content, fSitios);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 4:
                    fragmentRumba fRumba= new fragmentRumba();
                    fragmentTransaction.replace(android.R.id.content, fRumba);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;




            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Drawable[] Iconos= {getResources().getDrawable(R.drawable.i), getResources().getDrawable(R.drawable.i), getResources().getDrawable(R.drawable.i)};

        String[] item = {getResources().getString(R.string.comida), getResources().getString(R.string.cines),getResources().getString(R.string.teatros),getResources().getString(R.string.turismo),
                getResources().getString(R.string.rumba)};


        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);




        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, item));







    }



}
