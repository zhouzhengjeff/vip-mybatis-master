package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;

public interface DepartmentMapper {


    /**
     * 根据部门名称查询部门，同时查询出所在用户
     *
     * @param name
     * @return
     */
    Department findByName(String name);
}
