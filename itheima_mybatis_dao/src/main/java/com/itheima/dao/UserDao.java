package com.itheima.dao;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws IOException;

    public User findById(int id);
}
