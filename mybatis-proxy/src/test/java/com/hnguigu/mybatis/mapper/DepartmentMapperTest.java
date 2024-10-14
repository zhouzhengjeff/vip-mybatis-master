package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class DepartmentMapperTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            // 获取DepartmentMapper接口的代理对象。创建的代理对象实现了DepartmentMapper接口
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = departmentMapper.findByName("IBM");
            Set<User> users = department.getUsers();
            users.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}