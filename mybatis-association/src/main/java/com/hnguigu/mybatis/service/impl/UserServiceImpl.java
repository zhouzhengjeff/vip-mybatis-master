package com.hnguigu.mybatis.service.impl;

import com.hnguigu.mybatis.dao.impl.UserDaoImpl;
import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.service.DepartmentService;
import com.hnguigu.mybatis.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void assignUser(User user, Integer departmentId) {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("参数不能为空");
        }

        if (ObjectUtils.isEmpty(departmentId) || departmentId <= 0) {
            throw new IllegalArgumentException("部门编号非法，不能分配用户");
        }

        // TODO 1. 根据部门ID查询该部门
        Department department = this.departmentService.findDepartmentById(departmentId);
        if (department != null) {
            // TODO 2. 将用户分配到该部门（user.setDepartment(department)）
//            user.setDepartment(department);
            // TODO 3. 添加用户信息（userDao.save(user)）
            this.userDao.save(user);
        }
    }

    @Override
    public User findUserByName(String name) {
        if (ObjectUtils.isEmpty(name)) {
            throw new IllegalArgumentException("参数不能为空");
        }

        return this.userDao.findByName(name);
    }

    @Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("参数不能为空");
        }

        User user = this.userDao.getByName(name);
        if (ObjectUtils.isNotEmpty(user)) {
            Integer departmentId = user.getDepartmentId();
            return this.departmentService.findDepartmentById(departmentId);
        }

        return null;
    }

}
