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
public class IdCard implements Serializable {


    private static final long serialVersionUID = -463169031151961845L;
    private Integer id;
    private String number;
    private Person person;

}
