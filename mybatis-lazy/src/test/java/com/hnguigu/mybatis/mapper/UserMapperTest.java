package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class UserMapperTest {

    @Test
    public void testFindAll() {
        SqlSession sqlSession = null;
        List<User> userList = Collections.emptyList();

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            userList = userMapper.findAll();

            for (User user : userList) {
                System.out.println(user.getDepartment());
            }

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}