package com.example.karma_shops.model;

import com.example.karma_shops.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {

    ProductModel productModel;
    @BeforeEach
    void setUp() {
    productModel = new MySqlProductModel();
    }

    @Test
    void findAll() {
        List<Product> list = productModel.findAll();
        for (Product st :
                list) {
            System.out.println(st.toString());
        }
    }
}