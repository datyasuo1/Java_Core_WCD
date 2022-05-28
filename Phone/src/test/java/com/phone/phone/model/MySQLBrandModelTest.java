package com.phone.phone.model;

import com.phone.phone.entity.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySQLBrandModelTest {
    private BrandModel brandModel;


    @BeforeEach
    void setUp() {
        this.brandModel = new MySQLBrandModel();
    }

    @Test
    void save() {
        Brand category = new Brand();
        category.setName("Nokia.");
        brandModel.save(category);
        Brand category2 = new Brand();
        category2.setName("Oppo.");
        brandModel.save(category2);
        Brand category3 = new Brand();
        category3.setName("Iphone.");
        brandModel.save(category3);
        Brand category4 = new Brand();
        category4.setName("Sam Sung");
        brandModel.save(category4);
        assertEquals( 4 ,brandModel.findAll().size());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}