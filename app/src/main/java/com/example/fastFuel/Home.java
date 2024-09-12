package com.example.fastFuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.FastFuel.R;
import com.example.fastFuel.Categories.CategoriesAdopter;
import com.example.fastFuel.Categories.CategoriesModel;
import com.example.fastFuel.Recommended.RecommendedAdopter;
import com.example.fastFuel.Recommended.RecommendedModel;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.app_background));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.app_background));
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);

        // Code Restructuring: Extracted method for setting up profile click listener
        setupProfileClickListener();

        // Method for setting up the recommended items
        setupRecommendedItems();

        // Method for setting up the categories
        setupCategories();
    }

    // Code Restructuring: Extracted method for setting up profile click listener
    private void setupProfileClickListener() {
        // Find the profile ImageView and set up a click listener
        View profile = findViewById(R.id.ivProfile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Profile activity
                Intent intent = new Intent(view.getContext(), Profile.class);
                startActivity(intent);
            }
        });
    }

    // Code Restructuring: Extracted method for setting up recommended items
    private void setupRecommendedItems() {
        // Find the RecyclerView for Recommended items
        RecyclerView recRecyclerView = findViewById(R.id.recyclerView2);
        // List for Recommended items data
        List<RecommendedModel> recDataList = new ArrayList<>(); // Initialize Recommended items data list

        // Set up a LinearLayoutManager for the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recRecyclerView.setLayoutManager(layoutManager);

        // Add sample data for Recommended items
        recDataList.add(new RecommendedModel(R.drawable.pizza1, "Pizza", "$13.00"));
        recDataList.add(new RecommendedModel(R.drawable.burger, "Cheese Burger", "$9.00"));
        recDataList.add(new RecommendedModel(R.drawable.pizza3, "Vegetarian Pizza", "$15.00"));
        recDataList.add(new RecommendedModel(R.drawable.burger_large, "Chicken Burger", "$6.00"));

        // Initialize and set up the RecommendedAdapter for the RecyclerView
        RecommendedAdopter recAdapter = new RecommendedAdopter(this, recDataList);
        recRecyclerView.setAdapter(recAdapter);
    }

    // Code Restructuring: Extracted method for setting up categories
    private void setupCategories() {
        // Find the RecyclerView for Categories
        // Declare RecyclerViews and Adapters for Categories and Recommended items
        RecyclerView catRecyclerView = findViewById(R.id.mRecyclerView);
        // List for Categories data
        List<CategoriesModel> catDataList = new ArrayList<>(); // Initialize Categories data list

        // Set up a LinearLayoutManager for the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        catRecyclerView.setLayoutManager(layoutManager);

        // Add sample data for Categories
        catDataList.add(new CategoriesModel("cat_1", "Pizza"));
        catDataList.add(new CategoriesModel("cat_2", "Burger"));
        catDataList.add(new CategoriesModel("cat_3", "Hot Dog"));
        catDataList.add(new CategoriesModel("cat_4", "Drink"));
        catDataList.add(new CategoriesModel("cat_5", "Donate"));

        // Initialize and set up the CategoriesAdapter for the RecyclerView
        CategoriesAdopter catAdapter = new CategoriesAdopter(this, catDataList);
        catRecyclerView.setAdapter(catAdapter);
    }

    // Override onBackPressed to close the app
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // Close the app
    }
}
