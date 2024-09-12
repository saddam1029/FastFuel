package com.example.fastFuel.Recommended;

public class RecommendedModel {
    int rec_image;
    String rec_name;
    String rec_price;

    public RecommendedModel(int rec_image, String rec_name, String rec_price) {
        this.rec_image = rec_image;
        this.rec_name = rec_name;
        this.rec_price = rec_price;
    }

    public int getRec_image() {
        return rec_image;
    }

    public String getRec_name() {
        return rec_name;
    }

    public String getRec_price(){
        return rec_price;
    }
}
