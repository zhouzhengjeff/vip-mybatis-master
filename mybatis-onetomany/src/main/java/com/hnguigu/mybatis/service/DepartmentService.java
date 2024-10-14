package com.hnguigu.mybatis.service;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface DepartmentService {


    /**
     * 根据部门名称查询该部门的所有的用户
     *
     * @param name 部门名称
     * @return 该部门的所有用户
     */
    List<User> findUsersByDepartmentName(String name);




}
