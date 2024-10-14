package com.hnguigu.mybatis.service;

import com.hnguigu.mybatis.entity.Department;

public interface DepartmentService {

    void addDepartment(Department department);

    Department findDepartmentById(Integer id);
}
