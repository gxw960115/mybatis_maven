package com.itheima.multi.mapper;

import com.itheima.multi.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findAlls();

    List<User> findUserAndRoleAll();
}
