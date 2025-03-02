package com.hai811i.tp2partie21;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        ImageView detailFlag = findViewById(R.id.detailFlag);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailCapital = findViewById(R.id.detailCapital);
        TextView detailPopulation = findViewById(R.id.detailPopulation);
        TextView detailDescription = findViewById(R.id.detailDescription);
        Button btnShowLocation = findViewById(R.id.btnShowLocation);


        Intent intent = getIntent();
        String countryName = intent.getStringExtra("country_name");
        int countryFlag = intent.getIntExtra("country_flag", R.drawable.flag_france);
        String countryCapital = intent.getStringExtra("country_capital");
        long countryPopulation = intent.getLongExtra("country_population", 0);
        double latitude = intent.getDoubleExtra("country_latitude", 0);
        double longitude = intent.getDoubleExtra("country_longitude", 0);
        String countryDescription = intent.getStringExtra("country_description");


        detailFlag.setImageResource(countryFlag);
        detailName.setText(countryName);
        detailCapital.setText("Capitale : " + countryCapital);
        detailPopulation.setText("Population : " + countryPopulation);
        detailDescription.setText(countryDescription);



        btnShowLocation.setOnClickListener(v -> {
            Intent mapIntent = new Intent(DetailActivity.this, MapActivity.class);
            mapIntent.putExtra("latitude", latitude);
            mapIntent.putExtra("longitude", longitude);
            startActivity(mapIntent);
        });
    }
}