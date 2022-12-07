package com.itheima.test;

import com.itheima.multi.domain.Order;
import com.itheima.multi.domain.User;
import com.itheima.multi.mapper.OrderMapper;
import com.itheima.multi.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MybatisTest {
    Log log = LogFactory.getLog(MybatisTest.class);

    @Test
    public void test1() throws IOException {
        // InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        // OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        // List<Order> orderList = mapper.findAll();
        // if (orderList != null && !orderList.isEmpty()) {
        //     for (Order order : orderList) {
        //         log.debug(order != null ? order.toString() : "屁也没有！");
        //     }
        // } else {
        //     log.debug("屁也没有！");
        // }
        // sqlSession.close();
    }

    @Test
    public void testinsert() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setOrdertime(new Date());
        order.setTotal(29);
        order.setUid(5);
        int save = mapper.save(order);
        log.debug(save >= 0 ? "保存成功！" : "保存失败！");
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAlls();
        log.debug(userList != null && !userList.isEmpty() ? userList.toString() : "屁毛毛没有");
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findUserAndRoleAll();
        if (!userList.isEmpty() && userList != null) {
            System.out.println(userList.toString());
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                System.out.println(user != null ? user.toString() : "屁毛没有！");
                log.debug(user != null ? user.toString() : "屁毛没有！");
            }
        }

        sqlSession.close();
    }
}
