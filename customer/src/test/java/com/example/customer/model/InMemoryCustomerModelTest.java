package com.example.customer.model;

import com.example.customer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {
    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }

    @Test
    void create() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer("AB02",
                "Dat",
                "0211545",
                "dat.jpg",
                LocalDateTime.of(2002,3,10,10,10)
               );
        model.create(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer customer =model.findById("AB1");
        System.out.println(customer.toString());

    }

    @Test
    void update() {
        Customer customer = model.findById("AB1");
        customer.setName("dat2per");
        model.update("A001", customer);
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }

    @Test
    void delete() {
        model.delete("AB1");
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}