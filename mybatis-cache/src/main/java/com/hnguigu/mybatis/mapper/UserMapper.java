package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User findById(Integer id);

    void update(User user);

}
