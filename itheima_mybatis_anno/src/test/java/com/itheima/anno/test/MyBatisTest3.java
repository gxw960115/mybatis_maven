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
import java.util.List;

public class MyBatisTest3 {
    Log log = LogFactory.getLog(MyBatisTest3.class);
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findUserAndOrderAllTest() {
        List<User> userAndOrderAll = userMapper.findUserAndOrderAll();
        log.debug(userAndOrderAll != null && !userAndOrderAll.isEmpty() ? userAndOrderAll.toString() : "皮毛没有！");
    }
}
