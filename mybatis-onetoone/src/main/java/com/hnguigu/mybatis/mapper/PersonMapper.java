package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Person;

public interface PersonMapper {

    /**
     * 根据name查询该Person,同时查询出身份证信息
     * @param name
     * @return
     */
    Person findByName(String name);
}
