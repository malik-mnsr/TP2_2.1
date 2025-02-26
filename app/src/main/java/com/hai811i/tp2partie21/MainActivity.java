package com.hai811i.tp2partie21;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Country> countries = new ArrayList<>();
        countries.add(new Country("France", R.drawable.flag_france, "Paris", 67000000, 46.2276, 2.2137, "La France est un pays d'Europe connu pour sa culture, sa gastronomie et son histoire riche."));
        countries.add(new Country("Germany", R.drawable.flag_germany, "Berlin", 83000000, 51.1657, 10.4515, "L'Allemagne est un pays d'Europe centrale, célèbre pour son histoire et son économie robuste."));
        countries.add(new Country("Algeria", R.drawable.flag_algeria, "Alger", 45000000, 36.7538, 3.0588, "L'Algérie est un pays d'Afrique du Nord, connu pour son désert du Sahara et son patrimoine culturel."));
        countries.add(new Country("Brazil", R.drawable.flag_brazil, "Brasília", 214000000, -15.7801, -47.9292, "Le Brésil est le plus grand pays d'Amérique du Sud, célèbre pour son carnaval et la forêt amazonienne."));
        countries.add(new Country("Palestine", R.drawable.flag_palestine, "Gaza", 5000000, 31.7683, 35.2137, "La Palestine est une région du Moyen-Orient avec une histoire complexe et un riche patrimoine culturel."));
        countries.add(new Country("Japan", R.drawable.flag_japan, "Tokyo", 126000000, 35.6762, 139.6503, "Le Japon est un pays d'Asie de l'Est, réputé pour sa technologie avancée, sa culture unique et ses paysages magnifiques."));



        Collections.sort(countries);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Passer la liste triée à l'adaptateur
        CountryAdapter adapter = new CountryAdapter(countries, country -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("country_name", country.getName());
            intent.putExtra("country_flag", country.getFlagResId());
            intent.putExtra("country_capital", country.getCapital());
            intent.putExtra("country_description",country.getDescription());
            intent.putExtra("country_population", country.getPopulation());
            intent.putExtra("country_latitude", country.getLatitude());
            intent.putExtra("country_longitude", country.getLongitude());
            startActivity(intent);
        });

        // Associer l'adaptateur au RecyclerView
        recyclerView.setAdapter(adapter);
    }
}