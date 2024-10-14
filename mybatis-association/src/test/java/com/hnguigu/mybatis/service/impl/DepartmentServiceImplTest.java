package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest {

    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        this.departmentService = new DepartmentServiceImpl();
    }

    @Test
    public void testAddDepartment() {
        Department department = new Department();
        department.setName("IBM");
        department.setLocation("BOSTON");
        this.departmentService.addDepartment(department);
    }
}