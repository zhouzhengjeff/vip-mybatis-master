package com.hnguigu.mybatis.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatis的工具类
 * 获取SqlSession
 *
 * @author Jeff Chou
 */
public class MyBatisUtils {

    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            builder = new SqlSessionFactoryBuilder();

            // 从类路径找到mybatis-config.xml，将其生成字节流对象（InputStream）
            InputStream inputStream = MyBatisUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = builder.build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取SqlSession
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}
