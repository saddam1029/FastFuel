package com.example.fastFuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.FastFuel.R;


public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.btSighIn);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.app_background));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.app_background));
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Home.class);
                startActivity(intent);

                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

//                if (!userEmail.isEmpty() && !userPassword.isEmpty()) {
//                    if (userEmail.equals("user") && userPassword.equals("mad123")) {
//                        Intent intent = new Intent(v.getContext(), Home.class);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(Login.this, "Email and Password are Incorrect", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(Login.this, "Email and Password are required", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }
}