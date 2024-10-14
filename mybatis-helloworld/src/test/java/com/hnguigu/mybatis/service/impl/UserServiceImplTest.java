package com.hnguigu.mybatis.service.impl;

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
    public void testInsertUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("admin");
        user.setSalary(12.34F);
        user.setBirthday(new Date());

        this.userService.insertUser(user);
    }
}