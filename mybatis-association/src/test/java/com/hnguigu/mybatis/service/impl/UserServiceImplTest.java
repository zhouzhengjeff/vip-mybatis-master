package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        this.userService = new UserServiceImpl();
    }

    @Test
    public void testAssignUser() {
        User user = new User();
        user.setName("wangwu");
        user.setPassword("test");
        user.setSalary(55.34F);
        user.setBirthday(new Date());
        this.userService.assignUser(user, 1);
    }

    /*@Test
    public void testFindUserByName() {
        User user = this.userService.findUserByName("zhangsan");
        System.out.println(user);
        System.out.println(user.getDepartment());
    }*/

    @Test
    public void testFindDepartmentByUserName() {
        Department department = this.userService.findDepartmentByUserName("zhangsan");
        System.out.println(department);
    }
}