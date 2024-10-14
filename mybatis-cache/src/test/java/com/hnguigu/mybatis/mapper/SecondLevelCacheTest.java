package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SecondLevelCacheTest {

    @Test
    public void testCache1() {

        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 发SQL
            // 细节：缓存到底缓存的是什么？将这个对象缓存（不严谨）
            user = userMapper.findById(2);
            System.out.println(user);

            // 不会发SQL（不会跟数据库打交道）此处用到了一级缓存
            user = userMapper.findById(2);
            System.out.println(user);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    /**
     * 一级缓存的生命周期与SqlSession的生命周期一致
     * 关闭了SqlSession,一级缓存消失
     */
    @Test
    public void testCache2() {

        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 发SQL
            // 细节：缓存到底缓存的是什么？将这个对象缓存（不严谨）
            // 将user对象放入到了一级缓存，一级缓存和二级换有一个交互（一级缓存中的数据放入到二级缓存中）
            user = userMapper.findById(2);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 不会发SQL。使用到了二级缓存。从TransactionCacheManager中获取数据，在获取数据时与SqlSession没有任何关系
        user = userMapper.findById(2);
        System.out.println(user);
    }
}