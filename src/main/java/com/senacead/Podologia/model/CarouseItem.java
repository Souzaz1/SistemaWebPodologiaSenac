package com.senacead.Podologia.model;

public class CarouseItem {

    private String imageUrl;
    private String title;
    private String description;

    public CarouseItem(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    // Getters
    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
