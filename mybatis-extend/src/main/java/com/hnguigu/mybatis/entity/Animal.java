package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable {

    private static final long serialVersionUID = 2576944047131417696L;
    private Integer id;
    private String name;
}
