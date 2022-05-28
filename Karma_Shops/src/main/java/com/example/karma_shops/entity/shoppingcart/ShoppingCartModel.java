package com.example.karma_shops.entity.shoppingcart;

import java.util.List;

public interface ShoppingCartModel {
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    ShoppingCart findById(int id);
}
