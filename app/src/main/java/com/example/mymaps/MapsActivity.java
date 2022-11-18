package com.example.mymaps;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double lat;
    private Double lon;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        lat = getIntent().getDoubleExtra("lat", 0);
        lon = getIntent().getDoubleExtra("lon", 0);
        name = getIntent().getStringExtra("name");
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
        mMap = googleMap;

        // Add a marker in Chile and move the camera
        LatLng chile = new LatLng(lat, lon);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(chile)              // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .build();

        mMap.addMarker(new MarkerOptions().position(chile).icon((BitmapDescriptorFactory.fromResource(R.drawable.marker))).title(name));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

}
