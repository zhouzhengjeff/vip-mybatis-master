package com.hnguigu.mybatis.test;

import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.entity.UserExample;
import com.hnguigu.mybatis.mapper.UserMapper;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest {

    @Test
    public void testSave() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setUserName("lisi");
            user.setUserPassword("123");
            user.setUserSalary(100.00F);
            user.setUserBirthday(new Date());

            userMapper.insertSelective(user);

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

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByPrimaryKey(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFind() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // Hibernate
            // QBE（Query By Example 基于样例查询）
            UserExample userExample = new UserExample();

            // QBC（Query By Criteria 基于标准化查询）
            // where user_name like '%a%'
            userExample.createCriteria().andUserNameLike("%a%");

            List<User> userList = userMapper.selectByExample(userExample);
            userList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFind1() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.findByName("%a%");
            userList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFind2() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserExample userExample = new UserExample();

            // where user_name like ? and user_salary between ? and ?
            userExample.createCriteria().andUserNameLike("%a%").andUserSalaryBetween(100.00F, 200.00F);

            List<User> userList = userMapper.selectByExample(userExample);
            userList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

}
