package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = userMapper.findByName("zhangsan");
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}