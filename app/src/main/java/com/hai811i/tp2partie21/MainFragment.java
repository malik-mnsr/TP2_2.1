package com.hai811i.tp2partie21;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        List<Country> countries = new ArrayList<>();
        countries.add(new Country("France", R.drawable.flag_france, "Paris", 67000000, 46.2276, 2.2137, "La France est un pays d'Europe connu pour sa culture, sa gastronomie et son histoire riche."));
        countries.add(new Country("Germany", R.drawable.flag_germany, "Berlin", 83000000, 51.1657, 10.4515, "L'Allemagne est un pays d'Europe centrale, célèbre pour son histoire et son économie robuste."));
        countries.add(new Country("Algeria", R.drawable.flag_algeria, "Alger", 45000000, 36.7538, 3.0588, "L'Algérie est un pays d'Afrique du Nord, connu pour son désert du Sahara et son patrimoine culturel."));
        countries.add(new Country("Brazil", R.drawable.flag_brazil, "Brasília", 214000000, -15.7801, -47.9292, "Le Brésil est le plus grand pays d'Amérique du Sud, célèbre pour son carnaval et la forêt amazonienne."));
        countries.add(new Country("Palestine", R.drawable.flag_palestine, "Gaza", 5000000, 31.7683, 35.2137, "La Palestine est une région du Moyen-Orient avec une histoire complexe et un riche patrimoine culturel."));
        countries.add(new Country("Japan", R.drawable.flag_japan, "Tokyo", 126000000, 35.6762, 139.6503, "Le Japon est un pays d'Asie de l'Est, réputé pour sa technologie avancée, sa culture unique et ses paysages magnifiques."));


        Collections.sort(countries);


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        CountryAdapter adapter = new CountryAdapter(countries, country -> {

            Bundle bundle = new Bundle();
            bundle.putString("country_name", country.getName());
            bundle.putInt("country_flag", country.getFlagResId());
            bundle.putString("country_capital", country.getCapital());
            bundle.putString("country_description", country.getDescription());
            bundle.putLong("country_population", country.getPopulation());
            bundle.putDouble("country_latitude", country.getLatitude());
            bundle.putDouble("country_longitude", country.getLongitude());


            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);


            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });


        recyclerView.setAdapter(adapter);

        return view;
    }
}