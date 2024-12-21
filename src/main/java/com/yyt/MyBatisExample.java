package com.yyt;

import com.yyt.entity.User;
import com.yyt.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;
/**
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/19 11:48:41
 */

public class MyBatisExample {
    public static void main(String[] args) throws Exception {
        // 1. 读取 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 3. 获取 User
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 4. 调用 User 方法
            // 查询单个用户
            User user = userMapper.selectUserById(1);
            System.out.println("User: " + user.getName() + ", " + user.getEmail());

            // 查询所有用户
            List<User> users = userMapper.selectAllUsers();
            users.forEach(u -> System.out.println(u.getName() + ", " + u.getEmail()));

            // 插入用户
            User newUser = new User();
            newUser.setName("Charlie");
            newUser.setEmail("charlie@example.com");
            userMapper.insertUser(newUser);
            sqlSession.commit(); // 提交事务
            System.out.println("Inserted User ID: " + newUser.getId());

            // 更新用户
            newUser.setName("Charles");
            userMapper.updateUser(newUser);
            sqlSession.commit();

            // 删除用户
            userMapper.deleteUserById(newUser.getId());
            sqlSession.commit();
        }
    }
}
