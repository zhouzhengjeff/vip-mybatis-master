package com.hnguigu.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Animal {

    private static final long serialVersionUID = 6424701612946370917L;
    private String furColor;
}
