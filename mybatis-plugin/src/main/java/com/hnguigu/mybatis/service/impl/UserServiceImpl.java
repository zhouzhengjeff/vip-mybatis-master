package com.hnguigu.mybatis.service.impl;

import com.github.pagehelper.PageInfo;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public PageInfo<User> findPage(Integer pageNum, Integer pageSize) {
        /*PageHelper.startPage(2, 2);

        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName("%a%");

        List<User> userList = userMapper.find(userQueryDTO);
        pageInfo = new PageInfo<>(userList);*/
        return null;
    }
}
