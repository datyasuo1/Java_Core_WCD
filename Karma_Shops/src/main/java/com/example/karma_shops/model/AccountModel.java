package com.example.karma_shops.model;

import com.example.karma_shops.entity.Account;

import java.util.List;

public interface AccountModel {
    Account save(Account obj);

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
