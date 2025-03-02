package com.hai811i.tp2partie21;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button btnActivityVersion = findViewById(R.id.btnActivityVersion);
        Button btnFragmentVersion = findViewById(R.id.btnFragmentVersion);


        btnActivityVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });


        btnFragmentVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainFragmentActivity.class);
            startActivity(intent);
        });
    }
}