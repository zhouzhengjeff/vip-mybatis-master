package com.hnguigu.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 1058512267022446359L;

    private Integer id;
    private String name;
    private Integer roleId;
    private String roleName;
}