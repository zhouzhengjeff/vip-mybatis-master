package com.hnguigu.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.hnguigu.mybatis.entity.User;

public interface UserService {

    PageInfo<User> findPage(Integer pageNum, Integer pageSize);

}
