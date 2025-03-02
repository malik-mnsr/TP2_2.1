package com.hai811i.tp2partie21;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.maplibre.android.MapLibre;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.OnMapReadyCallback;
import org.maplibre.android.maps.Style;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.camera.CameraUpdateFactory;
import org.maplibre.android.annotations.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private double latitude;
    private double longitude;
    private static final String TAG = "MapFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MapLibre.getInstance(requireContext());


        View view = inflater.inflate(R.layout.fragment_map, container, false);


        Bundle bundle = getArguments();
        if (bundle != null) {
            latitude = bundle.getDouble("latitude", 0.0);
            longitude = bundle.getDouble("longitude", 0.0);
        }


        Log.d(TAG, "Received coordinates: Latitude = " + latitude + ", Longitude = " + longitude);


        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);


        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(@NonNull MapLibreMap mapLibreMap) {
        Log.d(TAG, "Map is ready");


        String accessToken = getString(R.string.jawg_access_token);
        String styleUrl = "https://api.jawg.io/styles/jawg-lagoon.json?access-token=" + accessToken;

        mapLibreMap.setStyle(styleUrl, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                Log.d(TAG, "Style loaded: " + style);


                LatLng latLng = new LatLng(latitude, longitude);


                mapLibreMap.addMarker(new MarkerOptions().position(latLng).setTitle("Location"));


                mapLibreMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                mapLibreMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f), 2000);
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}