package com.itheima.ssm.service;

import com.itheima.ssm.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    void save(Account account);

    List<Account> findAll();
}
