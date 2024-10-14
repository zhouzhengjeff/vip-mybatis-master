package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select(value =
            "SELECT USER_ID,\n" + "       USER_NAME,\n" + "       USER_PASSWORD,\n" + "       USER_SALARY,\n" + "    "
                    + "   USER_BIRTHDAY\n" + "FROM MYBATIS_USER\n" + "WHERE DEPARTMENT_ID = #{departmentId}")
    @Results(id = "UserBaseResultMap", value = {@Result(id = true, property = "id", column = "USER_ID"),
            @Result(property = "name", column = "USER_NAME"), @Result(property = "password",
            column = "USER_PASSWORD"), @Result(property = "salary", column = "USER_SALARY"), @Result(property =
            "birthday", column = "USER_BIRTHDAY")})
    List<User> findByDepartmentId(Integer departmentId);


    /**
     * 根据用户名称查询用户，但是同时查询该用户所在的部门
     * @param name
     * @return
     */
    @Select(value =
            "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_SALARY, USER_BIRTHDAY, DEPARTMENT_ID\n" + "FROM " +
                    "MYBATIS_USER\n" + "WHERE USER_NAME = #{name}")

    // @Results相当于映射文件中的<resultMap>
    @Results(id = "UserResultMap", value = {
            @Result(id = true, property = "id", column = "USER_ID"),
            @Result(property = "name", column = "USER_NAME"),
            @Result(property = "password", column = "USER_PASSWORD"),
            @Result(property = "salary", column = "USER_SALARY"),
            @Result(property = "birthday", column = "USER_BIRTHDAY"),
            @Result(property = "department", column = "department_id", one = @One(select = "com.hnguigu.mybatis" +
                    ".mapper.DepartmentMapper.getById"))
    })
    User findByName(String name);
}
