package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Animal;
import com.hnguigu.mybatis.entity.Cat;
import com.hnguigu.mybatis.entity.Dog;
import org.apache.ibatis.type.IntegerTypeHandler;

public interface AnimalMapper {

    void saveCat(Cat cat);

    void saveDog(Dog dog);

    Animal findById(Integer id);
}
