package com.example.karma_shops.entity.shoppingcart;

import com.example.karma_shops.entity.shoppingcart.CartItem;

import java.util.List;

public interface CartItemModel {
    CartItem save(CartItem cartItem);

    List<CartItem> findAll();

    CartItem findByShoppingCartId(int shoppingcartId);

}
