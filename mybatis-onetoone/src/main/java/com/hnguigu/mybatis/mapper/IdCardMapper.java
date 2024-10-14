package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.IdCard;

public interface IdCardMapper {

    IdCard findByNumber(String number);
}
