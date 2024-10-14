package com.hnguigu.mybatis.dao;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface DepartmentDao {


    /**
     * 根据部门名称查询部门，同时查询出所在用户
     * @param name
     * @return
     */
    Department findByName(String name);
}
