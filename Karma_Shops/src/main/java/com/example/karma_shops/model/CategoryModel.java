package com.example.karma_shops.model;

import com.example.karma_shops.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category create(Category obj);

    List<Category> findAll();


    Category findById(int id);

    Category update(int id, Category updateObj);

    boolean delete(int id);
}
