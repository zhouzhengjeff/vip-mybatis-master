package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRole implements Serializable {

    private static final long serialVersionUID = 8095586515270328366L;

    private Integer id;
    private Employee employee;
    private Role role;
}
