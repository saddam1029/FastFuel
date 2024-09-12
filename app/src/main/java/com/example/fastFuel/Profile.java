package com.example.fastFuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.os.Bundle;

import com.example.FastFuel.R;


public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.app_background));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.app_background));
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);
    }
}