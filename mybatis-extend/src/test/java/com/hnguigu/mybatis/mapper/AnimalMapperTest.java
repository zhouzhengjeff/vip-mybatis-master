package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Animal;
import com.hnguigu.mybatis.entity.Cat;
import com.hnguigu.mybatis.entity.Dog;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AnimalMapperTest {

    @Test
    public void saveCat() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);
            Cat cat = new Cat();
            cat.setName("小猫");
            cat.setEyeColor("black");
            animalMapper.saveCat(cat);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void saveDog() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);
            Dog dog = new Dog();
            dog.setName("小狗");
            dog.setFurColor("gray");
            animalMapper.saveDog(dog);
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
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);

            Animal animal = animalMapper.findById(2);
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println(cat);
            } else if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println(dog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}