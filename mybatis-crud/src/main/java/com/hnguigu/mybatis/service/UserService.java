package com.hnguigu.mybatis.service;

import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserService {

    void insertUser(User user);

    void deleteUser(User user);

    void deleteUserById(Integer id);

    void modifyUser(User user);

    User findUserById(Integer id);

    List<User> findAllUsers();

    /**
     * 根据条件查询用户列表
     * 条件是组合查询
     *
     * @param userQueryDTO
     * @return
     */
    List<User> findUsersByCondition(UserQueryDTO userQueryDTO);
}
