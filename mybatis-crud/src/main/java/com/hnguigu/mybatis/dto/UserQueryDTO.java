package com.hnguigu.mybatis.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询条件的封装
 */
@Data
public class UserQueryDTO implements Serializable {


    private static final long serialVersionUID = 4963791000583214819L;

    private String name;

    private Float minSalary;
    private Float maxSalary;

    private Date beginDate;
    private Date endDate;
}
