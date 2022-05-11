package com.example.customer.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
public void testCreateCustomer(){
    Customer customer = new Customer();
        customer.setId("AB1");
        customer.setName("Dat Pro");
        customer.setPhone("01411541214");
        customer.setImage("adj.jpg");
        customer.setDOB(LocalDateTime.of(2002,03,28,10,10));
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setStatus(1);
        System.out.printf(customer.toString());


    }

}