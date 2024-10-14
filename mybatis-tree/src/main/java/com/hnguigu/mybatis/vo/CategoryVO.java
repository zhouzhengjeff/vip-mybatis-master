package com.hnguigu.mybatis.vo;

import com.hnguigu.mybatis.entity.Category;
import com.hnguigu.mybatis.entity.Category1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 4947781267071889918L;

    private Category1 category;

    private List<Category1> children;
}
