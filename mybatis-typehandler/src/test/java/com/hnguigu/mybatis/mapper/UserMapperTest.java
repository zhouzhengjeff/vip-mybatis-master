package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Gender;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void testSave() {
        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            user = new User();
            user.setName("wangwu");

            // 插入的是0 因为MyBatisk底层实现了i一个默认的类型处理器
            user.setGender(Gender.MALE);

            userMapper.insert(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}