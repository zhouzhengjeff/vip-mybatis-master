package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

}
