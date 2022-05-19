package com.example.product.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart implements ShoppingCartAction{

    private int userId; // ai đặt
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private double totalPrice;
    private HashMap<String, CartItem> items;

    public ShoppingCart() {
    }

    public ShoppingCart(int userId, String shipName, String shipPhone, String shipAddress, String shipNote, double totalPrice, HashMap<String, CartItem> items) {
        this.userId = userId;
        this.shipName = shipName;
        this.shipPhone = shipPhone;
        this.shipAddress = shipAddress;
        this.shipNote = shipNote;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<String, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<String, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userId=" + userId +
                ", shipName='" + shipName + '\'' +
                ", shipPhone='" + shipPhone + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipNote='" + shipNote + '\'' +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    @Override
    public void add(Product product, int quantity) {
        CartItem cart = new CartItem(product.getId(), product.getName(), product.getThumbnail(), product.getPrice(), quantity);
        String itemId = String.valueOf(product.getId());
        if (items.size() == 0){
            items.put(itemId, cart);
            System.out.println("da them san pham ");
        }else {
            if (items.containsKey(itemId)){
                System.out.println("san pham ton tai");
            }else {
                items.put(itemId, cart);
                System.out.println("san pham duoc them");
            }
        }
    }

    @Override
    public void update(int quantity, String id) {
        
    }

    @Override
    public void remove(String id) {
       
    }

    @Override
    public ArrayList<CartItem> getListItems() {
       
    }
}
