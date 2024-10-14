package com.hnguigu.mybatis.dao.impl;

import com.hnguigu.mybatis.dao.UserDao;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {

    @Override
    public void save(User user) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            sqlSession.insert("com.hnguigu.mybatis.dao.UserDao.save", user);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Override
    public User findByName(String name) {
        User user = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            user = sqlSession.selectOne("com.hnguigu.mybatis.dao.UserDao.findByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        return user;
    }

    @Override
    public User getByName(String name) {
        User user = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            user = sqlSession.selectOne("com.hnguigu.mybatis.dao.UserDao.getByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        return user;
    }
}
