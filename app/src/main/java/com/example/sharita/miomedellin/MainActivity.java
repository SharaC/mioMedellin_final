package com.example.sharita.miomedellin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class MainActivity extends ActionBarActivity {
    protected TextView customFont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "gjgjg", Toast.LENGTH_LONG);
        setContentView(R.layout.mio_medellin);

        customFont= (TextView) findViewById(R.id.fuente2);
        Typeface font= Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf");
        customFont.setTypeface(font);





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id==R.id.cine){
            fragmentCines fCines = new fragmentCines();
            fragmentTransaction.replace(android.R.id.content,fCines);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.teatro){
            fragmentTeatro fteatro = new fragmentTeatro();
            fragmentTransaction.replace(android.R.id.content,fteatro);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.comida){
            fragmentComida fcomida = new fragmentComida();
            fragmentTransaction.replace(android.R.id.content,fcomida);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }



        if (id==R.id.sitios){
            fragmentSitios fsitios = new fragmentSitios();
            fragmentTransaction.replace(android.R.id.content,fsitios);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.about){
            fragmentAbout fAbout = new fragmentAbout();
            fragmentTransaction.replace(android.R.id.content,fAbout);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (id==R.id.rumba){
            fragmentRumba frumba = new fragmentRumba();
            fragmentTransaction.replace(android.R.id.content,frumba);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }
    public void abrirArvi (View v){
        Intent i=new Intent(this,MapsArvi.class);
        startActivity(i);
    }
    public void abrirMuseo (View v){
        Intent i=new Intent(this,MapsMuseo.class);
        startActivity(i);
    }
    public void abrirBotanico (View v){
        Intent i=new Intent(this,MapsBotanico.class);
        startActivity(i);
    }
    public void abrirUbicacion (View v){
        Intent i=new Intent(this,MapsMiubicacion.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()==0)
        {
            this.finish();
        }else{
            getFragmentManager().popBackStack();
        }

    }
}

