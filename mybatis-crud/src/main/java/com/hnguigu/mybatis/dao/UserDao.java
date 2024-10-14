package com.hnguigu.mybatis.dao;

import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    void remove(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();

}
