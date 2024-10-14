package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        this.userService = new UserServiceImpl();
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void testDeleteUser() {
        User user = this.userService.findUserById(1);
        this.userService.deleteUser(user);
    }

    @Test
    public void testModifyUser() {
        User user = this.userService.findUserById(2);
        user.setName("C罗");
        user.setSalary(88.34F);
        this.userService.modifyUser(user);
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void testFindAllUsers() {
        this.userService.findAllUsers().stream().forEach(System.out::println);
    }
}