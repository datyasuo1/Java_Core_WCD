package com.example.karma_shops.model;

import com.example.karma_shops.entity.Category;
import com.example.karma_shops.entity.Product;

import java.util.List;

public interface ProductModel {

    Product create(Product obj);

    List<Product> findAll();


    Product findById(int id);

    Product update(int id, Product updateObj);



    boolean delete(int id);

    List<Product> findByCateId(int categoryId);

}
