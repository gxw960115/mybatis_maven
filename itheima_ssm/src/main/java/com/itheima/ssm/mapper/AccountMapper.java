package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Account;

import java.util.List;

public interface AccountMapper {
    void save(Account account);

    List<Account> findAll();
}
