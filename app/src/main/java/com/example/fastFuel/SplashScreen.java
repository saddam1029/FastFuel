package com.example.fastFuel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.FastFuel.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.app_background));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.app_background));
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);

        // Using a Handler to delay the intent for the specified time
        delayAndStartMainActivity();
    }

    // Function to handle the delay and start the main activity
    private void delayAndStartMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    // Function to start the main activity
    private void startMainActivity() {
        Intent mainIntent = new Intent(SplashScreen.this, Login.class);
        startActivity(mainIntent);
        finish(); // close the splash screen activity
    }
}
