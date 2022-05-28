package com.example.karma_shops.entity.shoppingcart;

import com.example.karma_shops.entity.Product;
import com.example.karma_shops.entity.base.BaseEntity;
import com.example.karma_shops.entity.myenum.ShoppingCartStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends BaseEntity implements ShoppingCartAction {
    private int id;
    private int userId;
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private double totalPrice;
    private ShoppingCartStatus status;


    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public ShoppingCartStatus getStatus() {
        return status;
    }

    public void setStatus(ShoppingCartStatus status) {
        this.status = status;
    }

    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    HashMap<String,String> errors = new HashMap<>();
    public boolean isValid(){
        checkValidate();
        return errors.size()== 0;
    }
    private void checkValidate(){
        if (shipName == null || shipName.length() == 0){
            errors.put("shipName","Please enter name");
        }
        if (shipPhone == null || shipPhone.length() == 0){
            errors.put("shipPhone","Please enter phone}");
        }
        if (shipAddress == null || shipAddress.length() == 0){
            errors.put("shipAddress","Please enter address");
        }
        if (shipNote == null || shipNote.length() == 0){
            errors.put("shipNote","Please enter note");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public void add(Product product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem currentItem = items.get(product.getId());
            int updateQuantity = currentItem.getQuantity() + quantity;
            update(product, updateQuantity);
        } else {
            update(product, quantity);
        }
    }

    @Override
    public void update(Product product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem currentItem = items.get(product.getId());
            currentItem.setQuantity(quantity);
            items.put(product.getId(), currentItem);
        } else {
            CartItem item = new CartItem();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setProductThumbnail(product.getThumbnail());
            item.setUnitPrice(product.getPrice());
            item.setQuantity(quantity);
            items.put(product.getId(), item);
        }
    }

    @Override
    public void remove(Product product) {
        if(items.containsKey(product.getId())){
            items.remove(product.getId());
        }
    }

    @Override
    public ArrayList<CartItem> getListItems() {
        return new ArrayList<>(items.values());
    }
}
