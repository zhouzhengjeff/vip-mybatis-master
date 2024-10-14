package com.hnguigu.mybatis.dao;

import com.hnguigu.mybatis.entity.Department;

public interface DepartmentDao {

    void save(Department department);

    Department findById(Integer id);

}
