package com.hnguigu.mybatis.dao.impl;

import com.hnguigu.mybatis.dao.DepartmentDao;
import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public Department findByName(String name) {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            department = sqlSession.selectOne("com.hnguigu.mybatis.dao.DepartmentDao.findByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        return department;
    }
}
