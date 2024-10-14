package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 7048580121955237920L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;

    /**
     * 如果是Entity（建议与表一一对应），建议使用该种方式
     * 如果是DTO，VO（建议使用下面的方式）
     * 与数据库表的字段一一对应（不是很彻底的面向对象）
     */

     private Integer departmentId;


    // 更加面向对象
    /**
     * many-to-one（多对一）
     */
//    private Department department;

}
