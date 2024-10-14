package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.dao.UserDao;
import com.hnguigu.mybatis.dao.impl.UserDaoImpl;
import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.UserService;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    @Override
    public void insertUser(User user) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("");
        }

        this.userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("");
        }

        this.userDao.remove(user);
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public void modifyUser(User user) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("");
        }

        this.userDao.update(user);
    }

    @Override
    public User findUserById(Integer id) {
        if (ObjectUtils.isEmpty(id) || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.userDao.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userDao.findAll();
    }

    /*@Override
    public List<User> findUsersByCondition(UserQueryDTO userQueryDTO) {
        return Collections.emptyList();
    }*/

    @Override
    public List<User> findUsersByCondition(UserQueryDTO userQueryDTO) {
        if (ObjectUtils.isEmpty(userQueryDTO)) {
            throw new IllegalArgumentException("");
        }





        return null;
    }
}
