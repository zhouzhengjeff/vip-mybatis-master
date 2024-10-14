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
    private Department department;

}
