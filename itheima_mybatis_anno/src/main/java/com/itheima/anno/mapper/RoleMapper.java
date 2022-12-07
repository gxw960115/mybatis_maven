package com.itheima.anno.mapper;

import com.itheima.anno.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select ur.`role_id`,ur.`user_id`,r.`id`, r.`role_name` as roleName, r.`role_desc` as roleDesc from `sys_user_role` ur,`role` r where ur.role_id=r.id and ur.user_id=#{uid}")
    List<Role> findByUid(int uid);
}
