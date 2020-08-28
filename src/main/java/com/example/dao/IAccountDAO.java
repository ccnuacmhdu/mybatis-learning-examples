package com.example.dao;

import com.example.domain.Account;

import java.util.List;

public interface IAccountDAO {
    List<Account> findAll();
}
