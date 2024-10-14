package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    @Insert(value = "INSERT INTO MYBATIS_DEPARTMENT VALUES (#{id},#{name},#{location})")
    void save(Department department);

    @Select(value = "SELECT DEPARTMENT_ID ID, DEPARTMENT_NAME NAME, DEPARTMENT_LOCATION LOCATION FROM " +
            "MYBATIS_DEPARTMENT WHERE DEPARTMENT_ID = #{id}")
    Department findById(Integer id);

    @Select(value = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, DEPARTMENT_LOCATION FROM " + "MYBATIS_DEPARTMENT WHERE " +
            "DEPARTMENT_ID = #{id}")
    @Results(id = "DepartmentBaseResultMap", value = {
            @Result(property = "id", column = "DEPARTMENT_ID"),
            @Result(property = "name", column = "DEPARTMENT_NAME"),
            @Result(property = "location", column = "DEPARTMENT_LOCATION")
    })
    Department getById(Integer id);

    /**
     * 根据部门名称查询部门同时查询出该部门下的所有员工
     *
     * @param name
     * @return
     */
    /*@Select(value = "SELECT DISTINCT MD.DEPARTMENT_ID,\n" +
            "       MD.DEPARTMENT_NAME,\n" +
            "       MD.DEPARTMENT_LOCATION,\n" +
            "       MU.USER_ID,\n" +
            "       MU.USER_NAME,\n" +
            "       MU.USER_PASSWORD,\n" +
            "       MU.USER_SALARY,\n" +
            "       MU.USER_BIRTHDAY\n" +
            "FROM MYBATIS_DEPARTMENT MD\n" +
            "         LEFT JOIN MYBATIS_USER MU ON MD.DEPARTMENT_ID = MU.DEPARTMENT_ID\n" +
            "WHERE MD.DEPARTMENT_NAME = 'IBM'")
    @Results(id = "DepartmentResultMap", value = {
            @Result(id = true,property = "id", column = "DEPARTMENT_ID"),
            @Result(property = "name", column = "DEPARTMENT_NAME"),
            @Result(property = "location", column = "DEPARTMENT_LOCATION"),
            @Result(property = "users",
                    column = "department_id",
                    many = @Many(select = "com.hnguigu.mybatis.mapper.UserMapper.findByDepartmentId"))
    })
    List<Department> findByName(String name);*/


    @Select(value = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, DEPARTMENT_LOCATION FROM " + "MYBATIS_DEPARTMENT WHERE " +
            "DEPARTMENT_NAME = #{name}")
    @Results(id = "DepartmentResultMap", value = {
            @Result(id = true,property = "id", column = "DEPARTMENT_ID"),
            @Result(property = "name", column = "DEPARTMENT_NAME"),
            @Result(property = "location", column = "DEPARTMENT_LOCATION"),
            @Result(property = "users",
                    column = "department_id",
                    many = @Many(select = "com.hnguigu.mybatis.mapper.UserMapper.findByDepartmentId"))
    })
    Department findByName(String name);

}
