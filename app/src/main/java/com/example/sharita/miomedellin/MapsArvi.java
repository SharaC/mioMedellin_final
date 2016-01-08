package com.example.sharita.miomedellin;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsArvi extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private CameraUpdate mcam;

    public TextView data;
    public EditText latitud;
    public EditText longitud;
    public Button bActualiza;
    public Button bActual;

    public double lat;
    public  double lon;

    LocationManager locationManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_arvi);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);






        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updatePosition(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }

    public void click(View v) {
        Toast.makeText(getApplicationContext(), "Actualizado", Toast.LENGTH_SHORT).show();
        updatePosition();
    }

    public void ir (View v){
        lat= Double.parseDouble(latitud.getText().toString());
        lon= Double.parseDouble(longitud.getText().toString());
        setmMarker(new LatLng(lat,lon),"udea","alma mater");
        mcam = CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon),15);
        mMap.animateCamera(mcam);

    }


    public void updatePosition() {

        Location loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updatePosition(loc);
    }

    public void updatePosition(Location location){
        if (location!= null){
            lat = location.getLatitude();
            lon= location.getLongitude();
            data.setText(lat+"/"+lon+new java.util.Date(System.currentTimeMillis()).toString());

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng arvi = new LatLng(6.2891079, -75.5093481);
        // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker in nowhere").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        setmMarker(arvi,"Parque Arví","Sitio Turístico");
        mcam= CameraUpdateFactory.newLatLngZoom(arvi,12);
        mMap.animateCamera(mcam);
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(0,0)));
    }

    private void setmMarker(LatLng position, String titulo, String info){
        mMap.addMarker(new MarkerOptions()

                        .position(position)
                        .title(titulo)
                        .snippet(info)
                // .icon(BitmapDescriptorFactory.fromResource(icon))
        );
    }
}


