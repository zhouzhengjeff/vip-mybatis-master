package com.hnguigu.mybatis.dao.impl;

import com.hnguigu.mybatis.dao.DepartmentDao;
import com.hnguigu.mybatis.entity.Department;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public void save(Department department) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            sqlSession.insert("com.hnguigu.mybatis.dao.DepartmentDao.save", department);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Override
    public Department findById(Integer id) {
        Department department = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            department = sqlSession.selectOne("com.hnguigu.mybatis.dao.DepartmentDao.findById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }

        return department;
    }
}
