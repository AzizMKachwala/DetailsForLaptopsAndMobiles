package com.example.detailsforlaptopsandmobiles;

public class MobileDataModel {

    int id;
    String image,brand,purchaseYear,location,uploadedDate,category;
    double price;


    public MobileDataModel(int id, String image, String brand, double price, String purchaseYear, String location, String uploadedDate, String category) {
        this.id = id;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.purchaseYear = purchaseYear;
        this.location = location;
        this.uploadedDate = uploadedDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getPurchaseYear() {
        return purchaseYear;
    }

    public String getLocation() {
        return location;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public String getCategory() {
        return category;
    }
}
