package com.hnguigu.mybatis.dao.impl;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.dao.UserDao;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

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
}
