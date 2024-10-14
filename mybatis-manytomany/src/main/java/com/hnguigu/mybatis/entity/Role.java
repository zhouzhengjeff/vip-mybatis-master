package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {


    private static final long serialVersionUID = -2132127338570000450L;
    private Integer id;
    private String name;

    /**
     * 一对多
     * 在一方会有一个集合的引用
     */
    private Set<EmployeeRole> employeeRoles = new HashSet<>();

}
