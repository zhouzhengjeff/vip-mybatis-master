package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.dao.DepartmentDao;
import com.hnguigu.mybatis.dao.impl.DepartmentDaoImpl;
import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.DepartmentService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public List<User> findUsersByDepartmentName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("参数不能为空");
        }

        Department department = this.departmentDao.findByName(name);
        if (ObjectUtils.isNotEmpty(department)) {
            return department.getUsers().stream().collect(Collectors.toList());
        }

        return null;
    }
}
