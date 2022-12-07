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

public class MyBatisTest4 {
    Log log = LogFactory.getLog(MyBatisTest4.class);
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findUserAndRoleAllTest() {
        List<User> userAndRoleAll = userMapper.findUserAndRoleAll();
        log.debug(userAndRoleAll != null && !userAndRoleAll.isEmpty() ? userAndRoleAll.toString() : "屁毛没有！");
    }
}
