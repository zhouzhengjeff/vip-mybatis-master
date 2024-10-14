package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.dto.EmployeeDTO;
import com.hnguigu.mybatis.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 根据员工的名称查询该员工，同时查询出所有的角色
     *
     * @param name
     * @return
     */
    Employee findByName(String name);

    List<EmployeeDTO> findDTOsByName(String name);
}
