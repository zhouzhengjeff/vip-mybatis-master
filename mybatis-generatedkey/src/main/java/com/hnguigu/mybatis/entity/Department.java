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
public class Department implements Serializable {


    private static final long serialVersionUID = -5517435998850093742L;
    private Integer id;
    private String name;
    private String location;
}
