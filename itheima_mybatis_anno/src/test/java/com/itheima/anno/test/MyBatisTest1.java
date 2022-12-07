package com.itheima.anno.test;

import com.itheima.anno.domain.User;
import com.itheima.anno.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest1 {
    Log log = LogFactory.getLog(MyBatisTest1.class);
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");
        userMapper.save(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId(35);
        user.setUsername("tom");
        user.setPassword("258369147");
        user.setBirthday(new Date());
        userMapper.update(user);
    }

    @Test
    public void deleteTest() {
        userMapper.delete(23);
        userMapper.delete(25);
        userMapper.delete(27);
        userMapper.delete(32);
        userMapper.delete(33);
        userMapper.delete(34);
    }

    @Test
    public void findByIdTest() {
        User user = userMapper.findById(35);
        log.debug(user != null ? user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getBirthday() + "," + user.getRoleList() + "," + user.getOrderList() : "屁毛没有！");
    }

    @Test
    public void findAllTest() {
        List<User> userList = userMapper.findAll();
        if (!userList.isEmpty() && userList != null) {
            System.out.println(userList);
        }
    }
}
