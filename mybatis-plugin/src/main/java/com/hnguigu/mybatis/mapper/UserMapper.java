package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有的用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 有条件的查询
     * @param userQueryDTO 封装了查询条件的User对象
     * @return
     */
    List<User> find(UserQueryDTO userQueryDTO);
}
