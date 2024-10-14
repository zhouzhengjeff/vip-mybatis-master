package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    @Test
    public void findByQueryDTO() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            UserQueryDTO userQueryDTO = new UserQueryDTO();
            /*userQueryDTO.setName("%a%");
            userQueryDTO.setMaxSalary(10.00F);*/

            String dateString = "2024-08-28";
            Date date = DateUtils.parseDate(dateString, "yyyy-MM-dd");
            userQueryDTO.setBirthday(date);

            List<User> userList = userMapper.findByQueryDTO(userQueryDTO);
            userList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = userMapper.findById(1);
            user.setName("abc");
            user.setSalary(100.00F);

            userMapper.update(user);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Integer[] ids = new Integer[]{1, 2, 3};
            userMapper.deleteByIds(ids);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDeleteByIdList() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Integer[] ids = new Integer[]{4, 5, 6};
            List<Integer> idList = Arrays.asList(ids);
            userMapper.deleteByIdList(idList);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSave() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setName("abc");
            user.setPassword("abc");
            user.setSalary(100.00F);
            user.setBirthday(new Date());
            userMapper.save(user);

            System.out.println(user.getId());

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}