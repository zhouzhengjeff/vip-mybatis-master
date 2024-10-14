package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Person;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class PersonMapperTest {

    private PersonMapper personMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByName() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.findByName("zhangsan");
            System.out.println(person);
            System.out.println(person.getIdCard());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}