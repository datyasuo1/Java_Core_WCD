package com.example.product.entity;

import java.time.LocalDateTime;

public class Product {
    private String Id;
    private String Name;
    private String Image;
    private String Price;
    private String Description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Product(String id, String name, String image, String price, String description, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.Id = id;
        this.Name = name;
        this.Image = image;
        this.Price = price;
        this.Description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Product(String id, String name, String image, String price, String description) {
        this.Id = id;
        this.Name = name;
        this.Image = image;
        this.Price = price;
        this.Description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Product() {
        this.Id = "";
        this.Name = "";
        this.Image = "";
        this.Description="";
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", Price=" + Price +
                ", Description='" + Description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
