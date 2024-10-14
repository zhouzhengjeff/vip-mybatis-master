package com.hnguigu.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    /**
     * 单元测试实现无条件分页
     */
    @Test
    public void testFindPage1() {
        SqlSession sqlSession = null;
        PageInfo<User> pageInfo = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 开启分页，底层进行一系列的操作（拼SQL select * from xxx limit ?,?）
            // （2 - 1) * 3 = 3
            //   3
            // 这行代码必须出现在查询之前
            PageHelper.startPage(1, 2);
            List<User> userList = userMapper.findAll();
            pageInfo = new PageInfo<>(userList);

            System.out.println(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    /**
     * 单元测试实现有条件分页
     */
    @Test
    public void testFindPage2() {
        SqlSession sqlSession = null;
        PageInfo<User> pageInfo = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            PageHelper.startPage(2, 2);

            UserQueryDTO userQueryDTO = new UserQueryDTO();
            userQueryDTO.setName("%a%");

            List<User> userList = userMapper.find(userQueryDTO);
            pageInfo = new PageInfo<>(userList);

            System.out.println(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}