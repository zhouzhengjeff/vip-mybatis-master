package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.dao.UserDao;
import com.hnguigu.mybatis.dao.impl.UserDaoImpl;
import com.hnguigu.mybatis.service.UserService;
import org.apache.commons.lang3.ObjectUtils;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    @Override
    public void insertUser(User user) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("");
        }

        this.userDao.save(user);
    }
}
