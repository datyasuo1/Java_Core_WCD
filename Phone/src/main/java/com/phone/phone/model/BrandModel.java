package com.phone.phone.model;

import com.phone.phone.entity.Brand;

import java.util.List;

public interface BrandModel {
    Brand save(Brand brand);
    List<Brand> findAll();
    Brand findById(int id);
    Brand update(int id,Brand updatBrand);
    boolean delete(int id);
}
