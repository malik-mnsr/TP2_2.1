package com.hai811i.tp2partie21;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private ImageView detailFlag;
    private TextView detailName, detailCapital, detailPopulation, detailDescription;
    private Button btnShowLocation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Récupérer les vues
        detailFlag = view.findViewById(R.id.detailFlag);
        detailName = view.findViewById(R.id.detailName);
        detailCapital = view.findViewById(R.id.detailCapital);
        detailPopulation = view.findViewById(R.id.detailPopulation);
        detailDescription = view.findViewById(R.id.detailDescription);
        btnShowLocation = view.findViewById(R.id.btnShowLocation);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String countryName = bundle.getString("country_name");
            int countryFlag = bundle.getInt("country_flag", R.drawable.flag_france);
            String countryCapital = bundle.getString("country_capital");
            long countryPopulation = bundle.getLong("country_population", 0);
            double latitude = bundle.getDouble("country_latitude", 0);
            double longitude = bundle.getDouble("country_longitude", 0);
            String countryDescription = bundle.getString("country_description");


            detailFlag.setImageResource(countryFlag);
            detailName.setText(countryName);
            detailCapital.setText("Capitale : " + countryCapital);
            detailPopulation.setText("Population : " + countryPopulation);
            detailDescription.setText(countryDescription);


            btnShowLocation.setOnClickListener(v -> {

                Bundle bundle1 = new Bundle();
                bundle1.putDouble("latitude", latitude);
                bundle1.putDouble("longitude", longitude);


                MapFragment mapFragment = new MapFragment();
                mapFragment.setArguments(bundle1);


                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mapFragment)
                        .addToBackStack(null)
                        .commit();
            });
        }
        return view;
    }
}