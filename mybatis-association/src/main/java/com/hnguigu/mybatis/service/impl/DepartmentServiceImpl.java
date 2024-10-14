package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.dao.DepartmentDao;
import com.hnguigu.mybatis.dao.impl.DepartmentDaoImpl;
import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.service.DepartmentService;
import org.apache.commons.lang3.ObjectUtils;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void addDepartment(Department department) {
        if (ObjectUtils.isEmpty(department)) {
            throw new IllegalArgumentException();
        }

        this.departmentDao.save(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        if (ObjectUtils.isEmpty(id) || id <= 0) {
            throw new IllegalArgumentException();
        }

        return this.departmentDao.findById(id);
    }
}
