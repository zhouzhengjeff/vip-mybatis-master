package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentMapperTest {

    @Test
    public void testInsert() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = new Department();
            department.setName("研发部");
            department.setLocation("深圳");

            // 一般情况下插入部门后不会返回其主键 因此departmentId是null
            // 当下不能让departmentId为null,就需要进行设置<useGeneratedKey="true" keyProperty="id" keyColumn="user_id"/>
            departmentMapper.save(department);


            User user1 = new User();
            user1.setName("ggg");
            user1.setPassword("123456");
            user1.setSalary(1000.00F);
            user1.setBirthday(new Date());
            user1.setDepartmentId(department.getId());

            User user2 = new User();
            user2.setName("jjj");
            user2.setPassword("admin");
            user2.setSalary(2000.00F);
            user2.setBirthday(new Date());
            user2.setDepartmentId(department.getId());


            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.save(user1);
            userMapper.save(user2);


            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}