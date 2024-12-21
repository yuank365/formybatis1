package com.yyt.dao;


import com.yyt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author YYT
* @description 针对表【mapper】的数据库操作Mapper
* @createDate 2024-12-19 11:28:50
* @Entity generator.123.User
*/
@Mapper
public interface UserMapper {
    List<User> selectAllUsers();
    User selectUserById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUserById(int id);
}