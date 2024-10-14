package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Category;
import com.hnguigu.mybatis.entity.Category1;

import java.util.List;

public interface CategoryMapper {

    void save(Category category);

    Category findById(int id);

    /**
     * 根据类别名称查询该类别，同时查询父类别
     *
     * @param name
     * @return
     */
    Category findByName(String name);

    /**
     * 根据类别名称查询该类别
     * @param name
     * @return
     */
    Category1 getByName(String name);

    /**
     * 根据类别名称子类别
     * @param name
     */
    List<Category1> searchChildrenByName(String name);

}
