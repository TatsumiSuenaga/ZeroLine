package com.cse.team12.zeroline;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    final Context con = this;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        if (isNetworkAvailable()) {
            mMap = googleMap;

            LatLng chipotle = new LatLng(39.997516, -83.007255);
            LatLng blaze = new LatLng(39.997123, -83.007178);
            LatLng diaspora = new LatLng(40.005578, -83.008893);
            LatLng bib = new LatLng(39.998555, -83.007476);
            LatLng king = new LatLng(40.002134, -83.015152);
            LatLng myLocation;
            mMap.addMarker(new MarkerOptions().position(chipotle).title("Chipotle"));
            mMap.addMarker(new MarkerOptions().position(blaze).title("Blaze Pizza"));
            mMap.addMarker(new MarkerOptions().position(diaspora).title("Diaspora"));
            mMap.addMarker(new MarkerOptions().position(bib).title("Bibibop"));
            mMap.addMarker(new MarkerOptions().position(king).title("King Asad"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(chipotle));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(king, 15));
        }
        else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    con);

            // set title
            alertDialogBuilder.setTitle("Internet Connection not available");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Are you seriously trying to use maps without internet connection?" +
                            " Please uninstall this application.")
                    .setCancelable(false)
                    .setPositiveButton("Okay...",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            MapsActivity.this.finish();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        }
    }

    // Check all connectivities whether available or not
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    /**private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }**/
}
