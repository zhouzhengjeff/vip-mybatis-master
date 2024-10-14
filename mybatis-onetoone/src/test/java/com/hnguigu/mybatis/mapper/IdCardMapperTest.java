package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.IdCard;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class IdCardMapperTest {

    @Test
    public void findByNumber() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
            IdCard idCard = idCardMapper.findByNumber("88888888");
            System.out.println(idCard);
            System.out.println(idCard.getPerson());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}