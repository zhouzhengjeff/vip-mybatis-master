package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DepartmentMapperTest {

    @Test
    public void testFindAll() {
        SqlSession sqlSession = null;
        List<Department> departmentList = Collections.emptyList();

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            departmentList = departmentMapper.findAll();

            for (Department department : departmentList) {
                Set<User> users = department.getUsers();
                for (User user : users) {
                    System.out.println(user);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}