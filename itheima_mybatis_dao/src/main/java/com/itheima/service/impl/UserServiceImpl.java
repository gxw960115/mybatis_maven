package com.itheima.service.impl;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Override
    public List<User> findAll() throws IOException {
        return userMapper.findAll();
    }
}
