package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class FirstLevelCacheTest {

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

            // 不会发SQL（不会跟数据库打交道）
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
            user = userMapper.findById(2);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 会发SQL
        user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testCache3() {

        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 发SQL
            // 细节：缓存到底缓存的是什么？将这个对象缓存（不严谨）
            user = userMapper.findById(2);
            System.out.println(user);

            // 手动干预缓存，清空缓存
            sqlSession.clearCache();

            // 缓存中没有数据，只能访问数据库。会发SQL
            user = userMapper.findById(2);
            System.out.println(user);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testCache4() {

        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 发SQL
            // 细节：缓存到底缓存的是什么？将这个对象缓存（不严谨）
            user = userMapper.findById(2);
            System.out.println(user);

            // 修改了查询出的对象的属性值，缓存会清空
            user.setName("lisi");
            userMapper.update(user);

            // 会发SQL
            user = userMapper.findById(2);
            System.out.println(user);

            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}