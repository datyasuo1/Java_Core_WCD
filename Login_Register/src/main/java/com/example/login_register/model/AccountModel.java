package com.example.login_register.model;

import com.example.login_register.entity.Account;

import java.util.List;

public interface AccountModel {
    Account save(Account obj); // lưu thông tin.

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
