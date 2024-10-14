package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * 类别
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category implements Serializable {


    private static final long serialVersionUID = 3411919008002927244L;

    private Integer id;
    private String name;

    /**
     * 父类别
     */
    private Category parent;

    /**
     * 子类别（多个，建立成集合）
     */
    private Set<Category> children;
}
