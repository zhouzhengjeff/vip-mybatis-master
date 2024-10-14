package com.hnguigu.mybatis.dao;

import com.hnguigu.mybatis.entity.User;

public interface UserDao {

    void save(User user);

    User findByName(String name);

    /**
     * 根据用户名称查询用户（没有部门的数据）
     * @param name
     * @return
     */
    User getByName(String name);
}
