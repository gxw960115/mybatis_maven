package com.itheima.service;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    public List<User> findAll() throws IOException;
}
