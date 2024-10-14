package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface DepartmentMapper {


    List<Department> findAll();


}
