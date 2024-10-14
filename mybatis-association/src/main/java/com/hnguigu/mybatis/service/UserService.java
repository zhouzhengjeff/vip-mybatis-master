package com.hnguigu.mybatis.service;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;

public interface UserService {


    /**
     * 添加用户的同时将该用户分配到部门
     *
     * @param user
     */
    void assignUser(User user, Integer departmentId);

    /**
     * 根据用户名称查询该用户所在的部门
     */
    User findUserByName(String name);

    /**
     * 根据用户名称查询部门
     * @param name
     * @return
     */
    Department findDepartmentByUserName(String name);

}
