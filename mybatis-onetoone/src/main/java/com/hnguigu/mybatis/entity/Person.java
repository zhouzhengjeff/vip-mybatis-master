package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 将Person对象当成多方（实际上不是多方，而是一方）Person类对应的表中有一个外键，但是这个外键必须唯一（建立唯一约束）
 * IdCard是一方
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Serializable {


    private static final long serialVersionUID = -3740612822510513993L;
    private Integer id;
    private String name;

    /**
     * 多方有一方的引用，体现出多对一
     */
    private IdCard idCard;
}
