package com.example.fastFuel.Categories;

public class CategoriesModel {

    String cat_image;
    String cat_name;

    public CategoriesModel(String cat_image, String cat_name) {
        this.cat_image = cat_image;
        this.cat_name = cat_name;
    }


    public String getCat_image() {
        return cat_image;
    }

    public String getCat_name() {
        return cat_name;
    }
}
