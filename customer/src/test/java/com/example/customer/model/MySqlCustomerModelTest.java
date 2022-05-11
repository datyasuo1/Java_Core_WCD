package com.example.customer.model;

import com.example.customer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.create(new Customer("ABD1", "Dat", "0202151554", "adad.jpg", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer st :
                list) {
            System.out.println(st.toString());
        }
    }

    @Test
    void findById() {
        Customer student = model.findById("AB1");
        assertEquals("Dat", student.getName());
        Student student1 = model.findById("A002");
        assertEquals("Luyen", student1.getFullName());
    }

    @Test
    void update() {
        Student student = model.findById("A001");
        student.setFullName("Xuan Van Hung");
        model.update("A001", student);
        Student newUpdateStudent = model.findById("A001");
        assertEquals("Xuan Van Hung", newUpdateStudent.getFullName());
    }

    @Test
    void delete() {
        model.delete("A001");
        Student student = model.findById("A001");
        assertEquals(null, student);
    }
}