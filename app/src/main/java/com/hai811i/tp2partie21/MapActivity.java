package com.hai811i.tp2partie21;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import org.maplibre.android.MapLibre;
import org.maplibre.android.annotations.MarkerOptions;
import org.maplibre.android.camera.CameraUpdateFactory;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.OnMapReadyCallback;
import org.maplibre.android.maps.Style;
import org.maplibre.android.geometry.LatLng;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import org.maplibre.android.MapLibre;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.OnMapReadyCallback;
import org.maplibre.android.maps.Style;
import org.maplibre.android.geometry.LatLng;


public class MapActivity extends Activity implements OnMapReadyCallback {

    private MapView mapView;
    private double latitude;
    private double longitude;
    private static final String TAG = "MapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialiser MapLibre
        MapLibre.getInstance(this);

        // Définir le layout
        setContentView(R.layout.activity_map);

        // Récupérer les coordonnées passées par DetailActivity
        Intent intent = getIntent();
        latitude = intent.getDoubleExtra("latitude", 0.0);
        longitude = intent.getDoubleExtra("longitude", 0.0);

        // Log des coordonnées reçues
        Log.d(TAG, "Received coordinates: Latitude = " + latitude + ", Longitude = " + longitude);

        // Initialiser MapView
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // Charger la carte de manière asynchrone
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull MapLibreMap mapLibreMap) {
        Log.d(TAG, "Map is ready");

        // Définir le style de la carte avec Jawg Maps
        String accessToken = getString(R.string.jawg_access_token); // Token d'accès Jawg
        String styleUrl = "https://api.jawg.io/styles/jawg-streets.json?access-token=" + accessToken;

        mapLibreMap.setStyle(styleUrl, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                Log.d(TAG, "Style loaded: " + style);


                LatLng latLng = new LatLng(latitude, longitude);


                mapLibreMap.addMarker(new MarkerOptions().position(latLng).title("Location"));
                // Centrer la carte sur la position
                mapLibreMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                mapLibreMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f), 2000); // 2000 ms = 2 secondes
            }
        });
    }

    // Gestion du cycle de vie de MapView
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}