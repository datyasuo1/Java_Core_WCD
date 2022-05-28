package com.example.karma_shops.entity.shoppingcart;

import com.example.karma_shops.entity.base.BaseEntity;
import com.example.karma_shops.entity.myenum.CartItemStatus;

import java.time.LocalDateTime;

public class CartItem extends BaseEntity {
    private int ShoppingcartId;
    private int productId;
    private String productName;
    private String productThumbnail;
    private double unitPrice;
    private int quantity;

    private CartItemStatus status;
    public CartItem() {
    }

    public CartItemStatus getStatus() {
        return status;
    }

    public void setStatus(CartItemStatus status) {
        this.status = status;
    }

    public int getShoppingcartId() {
        return ShoppingcartId;
    }

    public void setShoppingcartId(int shoppingcartId) {
        ShoppingcartId = shoppingcartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
