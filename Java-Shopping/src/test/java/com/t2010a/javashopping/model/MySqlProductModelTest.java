package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    ProductModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlProductModel();
    }

    @Test
    void findById() {
        Product product = model.findById("SP001");
        assertEquals("Hooded thermal anorak",product.getName());
    }

    @Test
    void update() {
        Product product = model.findById("SP002");
        product.setName("Update");
        model.update("SP002",product);
        Product product1 = model.findById("SP002");
        assertEquals("Update",product1.getName());
    }

    @Test
    void delete() {
        model.delete("SP002");
        Product product = model.findById("SP002");
        assertEquals(null,product);
    }
}