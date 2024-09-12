package com.example.fastFuel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FastFuel.R;

public class AddToCart extends AppCompatActivity {

    // Member variables
    private Button btnCancel;
    private Button btnConfirm;
    private ImageView ivBigFoodPic;
    private TextView tvFoodName;
    private TextView tvFoodPrice;
    private TextView tvSubtotalPrice;
    private TextView tvTotalPrice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        // Initialize views
        initializeViews();

        // Retrieve data from Intent extras
        String foodName = getIntent().getStringExtra("foodName");
        String foodPrice = getIntent().getStringExtra("foodPrice");
        String subPrice = getIntent().getStringExtra("totalPrice"); // Subtotal from the FoodDetail activity
        int foodPicResId = getIntent().getIntExtra("foodPic", 0);
        int shippingPrice = 10; // Assume shipping price is 10 dollars

        // Extract numeric value from subPrice
        assert subPrice != null;
        String subPriceNumeric = subPrice.replaceAll("[^0-9.]", ""); // Remove non-numeric characters

        // Convert the extracted numeric value to a double
        double subtotal = Double.parseDouble(subPriceNumeric);

        double totalPrice = subtotal + shippingPrice;

        // Set data to the views
        setFoodDetails(foodName, foodPrice, subPrice, totalPrice, foodPicResId);

        // Set up click listeners
        setButtonClickListeners();
    }

    // Initialize views to avoid repetitive code
    private void initializeViews() {
        btnCancel = findViewById(R.id.btCancel);
        btnConfirm = findViewById(R.id.btConform);
        ivBigFoodPic = findViewById(R.id.ivFood);
        tvFoodName = findViewById(R.id.tvFoodName);
        tvFoodPrice = findViewById(R.id.tvFoodPrice);
        tvSubtotalPrice = findViewById(R.id.tvSubPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
    }

    // Set data to the views
    // Set data to the views
    @SuppressLint("DefaultLocale")
    private void setFoodDetails(String foodName, String foodPrice, String subPrice, double totalPrice, int foodPicResId) {
        if (tvFoodName != null) {
            tvFoodName.setText(foodName);
        }
        if (tvFoodPrice != null) {
            tvFoodPrice.setText(foodPrice);
        }
        if (tvSubtotalPrice != null) {
            tvSubtotalPrice.setText(subPrice);
        }
        if (tvTotalPrice != null) {
            tvTotalPrice.setText(String.format("$ %.2f", totalPrice)); // Display the total price with two decimal places
        }
        if (ivBigFoodPic != null) {
            ivBigFoodPic.setImageResource(foodPicResId);
        }
    }


    // Set up click listeners
    private void setButtonClickListeners() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelOrder();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOrder();
            }
        });
    }

    // Code Restructuring: Moved cancel order logic to a separate method
    private void cancelOrder() {
        Toast.makeText(AddToCart.this, "Order Canceled", Toast.LENGTH_LONG).show();
        navigateToHome();
    }

    // Code Restructuring: Moved confirm order logic to a separate method
    private void confirmOrder() {
        Toast.makeText(AddToCart.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
    }

    // Code Restructuring: Moved navigation logic to a separate method
    private void navigateToHome() {
        Intent intent = new Intent(AddToCart.this, Home.class);
        startActivity(intent);
    }
}
