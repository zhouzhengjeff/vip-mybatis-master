package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;

public interface DepartmentMapper {

    /**
     * 添加部门
     * @param department
     */
    void save(Department department);
}
