package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DepartmentMapperTest {

    @Test
    public void testSave() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = new Department();
            department.setName("IBM");
            department.setLocation("LOS");

            departmentMapper.save(department);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindById() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = departmentMapper.findById(1);
            System.out.println(department);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetById() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = departmentMapper.getById(1);
            System.out.println(department);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

            Department department = departmentMapper.findByName("IBM");
            System.out.println(department);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}