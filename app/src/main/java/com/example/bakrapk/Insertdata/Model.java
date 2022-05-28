package com.example.bakrapk.Insertdata;

public class Model {
    private String imageName;
    private String imagePrice;
    private String Discriptionn;
    private String imageUrl;

    public Model() {
    }

    public Model(String imageName, String imagePrice, String discriptionn, String imageUrl) {
        this.imageName = imageName;
        this.imagePrice = imagePrice;
        Discriptionn = discriptionn;
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePrice() {
        return imagePrice;
    }

    public void setImagePrice(String imagePrice) {
        this.imagePrice = imagePrice;
    }

    public String getDiscriptionn() {
        return Discriptionn;
    }

    public void setDiscriptionn(String discriptionn) {
        Discriptionn = discriptionn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}