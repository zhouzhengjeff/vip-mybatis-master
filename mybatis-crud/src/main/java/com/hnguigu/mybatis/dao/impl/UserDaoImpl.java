package com.hnguigu.mybatis.dao.impl;

import com.hnguigu.mybatis.dao.UserDao;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void save(User user) {
        SqlSession session = null;

        try {
            session = MyBatisUtils.getSqlSession();
            session.insert("com.hnguigu.mybatis.dao.UserDao.save", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(session);
        }
    }

    @Override
    public void remove(User user) {
        SqlSession session = null;

        try {
            session = MyBatisUtils.getSqlSession();
            session.delete("com.hnguigu.mybatis.dao.UserDao.remove", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(session);
        }
    }

    @Override
    public void update(User user) {
        SqlSession session = null;

        try {
            session = MyBatisUtils.getSqlSession();
            session.update("com.hnguigu.mybatis.dao.UserDao.update", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(session);
        }
    }

    @Override
    public User findById(Integer id) {
        User user = null;
        SqlSession session = null;

        try {
            session = MyBatisUtils.getSqlSession();
            user = session.selectOne("com.hnguigu.mybatis.dao.UserDao.findById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(session);
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = Collections.emptyList();
        SqlSession session = null;

        try {
            // 获取SqlSession
            session = MyBatisUtils.getSqlSession();
            userList = session.selectList("com.hnguigu.mybatis.dao.UserDao.findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(session);
        }

        return userList;
    }
}
