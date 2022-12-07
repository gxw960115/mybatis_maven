package com.itheima.anno.mapper;

import com.itheima.anno.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into `user` values (#{id},#{username},#{password},#{birthday})")
    void save(User user);

    @Update("update `user` set `username`=#{username},`password`=#{password},`birthday`=#{birthday} where `id`=#{id}")
    void update(User user);

    @Delete("delete from `user` where id=#{id}")
    void delete(int id);

    @Select("select * from `user` where id = #{id}")
    User findById(int id);

    @Select("select * from `user`")
    List<User> findAll();

    @Select("select * from `user`")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.anno.mapper.OrderMapper.findByUid")
            )
    })
    List<User> findUserAndOrderAll();

    @Select("select * from `user`")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.anno.mapper.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRoleAll();
}
