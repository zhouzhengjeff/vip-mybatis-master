package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类别
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category1 implements Serializable {


    private static final long serialVersionUID = 3411919008002927244L;

    private Integer id;
    private String name;
    private Integer parentId;

}
