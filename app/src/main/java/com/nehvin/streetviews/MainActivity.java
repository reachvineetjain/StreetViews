package com.nehvin.streetviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;


public class MainActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreetViewPanoramaFragment streetViewPanorama =
                (StreetViewPanoramaFragment)getFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanorama.getStreetViewPanoramaAsync(this);

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(37.3519931,-121.9952535));
        streetViewPanorama.setStreetNamesEnabled(false);
//        streetViewPanorama.setUserNavigationEnabled(false);
        streetViewPanorama.setZoomGesturesEnabled(false);
        StreetViewPanoramaCamera cp = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
//        StreetViewPanoramaCamera cp = new StreetViewPanoramaCamera.Builder()
//                .zoom(streetViewPanorama.getPanoramaCamera().zoom + 0.5f)
//                .tilt(streetViewPanorama.getPanoramaCamera().tilt)
//                .bearing(streetViewPanorama.getPanoramaCamera().bearing)
//                .build();
        streetViewPanorama.animateTo(cp,10000);
    }
}