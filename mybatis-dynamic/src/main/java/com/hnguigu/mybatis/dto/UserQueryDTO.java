package com.hnguigu.mybatis.dto;

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
public class UserQueryDTO implements Serializable {


    private static final long serialVersionUID = 4963791000583214819L;

    private String name;
    private Float minSalary;
    private Float maxSalary;
    private Date birthday;
}
