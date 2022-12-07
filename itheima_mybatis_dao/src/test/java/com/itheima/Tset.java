package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserMapper;
import com.itheima.dao.impl.UserMapperImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Tset {
    @Test
    public void findAll() throws IOException {
        UserDao userMapper = new UserMapperImpl();
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void testProxyDao() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得MyBatis框架生成的UserMapper接口的实现类
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
        sqlSession.close();
    }
}
