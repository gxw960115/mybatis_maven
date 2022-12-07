package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    Log log = LogFactory.getLog(MyBatisTest.class);

    @Test
    // 查询全部
    public void selectTest() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        log.debug(!userList.isEmpty() && userList != null ? "查询成功！\n" + userList : "查询失败！\n" + userList);
        // 释放资源
        sqlSession.close();
    }

    @Test
    // 根据id查询
    public void selByIdTest() throws IOException {
        User user = new User();
        user.setId(10);
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User userResult = sqlSession.selectOne("userMapper.findById", user);
        log.debug(userResult != null ? "查询成功！\n" + userResult : "查询失败！\n" + userResult);
        sqlSession.close();
    }

    @Test
    public void saveTest() throws IOException {
        User user = new User();
        user.setUsername("张五");
        user.setPassword("123456");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int count = sqlSession.insert("userMapper.save", user);
        sqlSession.commit();
        log.debug(count == 1 ? "保存成功！" : "保存失败！");
        sqlSession.close();
    }

    @Test
    public void updateTest() throws IOException {
        User user = new User();
        user.setId(10);
        user.setUsername("zhangsan");
        user.setPassword("123456");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        int count = sqlSession.update("userMapper.update", user);
        log.debug(count == 1 ? "修改成功！" : "修改失败！");
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {
        User user = new User();
        user.setId(10);
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        int count = sqlSession.delete("userMapper.delete", user);
        log.debug(count == 1 ? "删除成功！" : "删除失败！");
        sqlSession.close();
    }
}
