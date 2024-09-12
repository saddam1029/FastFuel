package com.example.fastFuel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.FastFuel.R;

public class FoodDetail extends AppCompatActivity {

    // Declare UI elements
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvTotalPrice;
    private ImageView ivPic;
    private Button addToCart;
    private ImageView plus;
    private ImageView minus;
    private TextView quantity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        // Retrieve the passed data from MainActivity
        String foodName = getIntent().getStringExtra("foodName");
        String foodPrice = getIntent().getStringExtra("foodPrice");
        int foodPicResId = getIntent().getIntExtra("foodPic", 0);

        // Initialize views
        initializeViews();

        // Set the retrieved data to respective views
        setFoodDetails(foodName, foodPrice, foodPicResId);

        // Perform calculations and set listeners
        performCalculations();

        // Handle adding to cart
        handleAddToCart();
    }

    // Method to initialize UI elements
    private void initializeViews() {
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvFoodPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        ivPic = findViewById(R.id.ivBigFoodPic);
        addToCart = findViewById(R.id.btAddToCart);
        plus = findViewById(R.id.tvPlus);
        minus = findViewById(R.id.tvMinus);
        quantity = findViewById(R.id.tvQuantity);
    }

    // Method to set food details on UI
    private void setFoodDetails(String foodName, String foodPrice, int foodPicResId) {
        tvName.setText(foodName);
        tvPrice.setText(foodPrice);
        tvTotalPrice.setText(foodPrice);
        ivPic.setImageResource(foodPicResId);
    }

    // Method to perform calculations and set listeners for UI elements
    private void performCalculations() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });
    }

    // Method to handle the "Add to Cart" button click
    private void handleAddToCart() {
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = parseTotalPrice();

                if (totalPrice <= 0.0) {
                    showToast("Please select items to add to cart!");
                } else {
                    showToast("Add to Cart Successfully");
                    navigateToAddToCart();
                }
            }
        });
    }

    // Method to parse the total price from the UI
    private double parseTotalPrice() {
        return Double.parseDouble(tvTotalPrice.getText().toString().substring(1)); // Remove the '$' sign
    }

    // Method to display a toast message
    private void showToast(String message) {
        Toast.makeText(FoodDetail.this, message, Toast.LENGTH_SHORT).show();
    }

    // Method to navigate to the AddToCart activity with relevant data
    private void navigateToAddToCart() {
        Intent intent = new Intent(FoodDetail.this, AddToCart.class);
        intent.putExtra("foodName", tvName.getText().toString());
        intent.putExtra("foodPrice", tvPrice.getText().toString());
        intent.putExtra("totalPrice", tvTotalPrice.getText().toString());
        intent.putExtra("foodPic", getIntent().getIntExtra("foodPic", 0));
        startActivity(intent);
    }

    // Method to increment the quantity
    private void incrementQuantity() {
        int currentQuantity = Integer.parseInt(quantity.getText().toString());
        int newQuantity = currentQuantity + 1;
        quantity.setText(String.valueOf(newQuantity));
        updateTotalPrice();
    }

    // Method to decrement the quantity
    private void decrementQuantity() {
        int currentQuantity = Integer.parseInt(quantity.getText().toString());
        int newQuantity = currentQuantity - 1;
        if (newQuantity >= 0) {
            quantity.setText(String.valueOf(newQuantity));
            updateTotalPrice();
        }
    }

    // Method to update the total price based on quantity
    @SuppressLint("DefaultLocale")
    private void updateTotalPrice() {
        double pricePerItem = Double.parseDouble(tvPrice.getText().toString().replace("$", ""));
        int currentQuantity = Integer.parseInt(quantity.getText().toString());
        double newTotalPrice = pricePerItem * currentQuantity;
        tvTotalPrice.setText(String.format("$%.2f", newTotalPrice));
    }
}
