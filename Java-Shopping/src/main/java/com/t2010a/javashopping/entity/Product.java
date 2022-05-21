package com.t2010a.javashopping.entity;

import java.time.LocalDateTime;

public class Product {
    private String id;
    private String name;
    private double price;
    private String content;
    private String size;
    private int qty;
    private int sku;
    private String category;
    private String tag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Product() {
    }

    public Product(String id, String name, double price, String content, String size, int qty, int sku, String category, String tag, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.content = content;
        this.size = size;
        this.qty = qty;
        this.sku = sku;
        this.category = category;
        this.tag = tag;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Product(String id, String name, double price, String content, String size, int qty, int sku, String category, String tag) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.content = content;
        this.size = size;
        this.qty = qty;
        this.sku = sku;
        this.category = category;
        this.tag = tag;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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