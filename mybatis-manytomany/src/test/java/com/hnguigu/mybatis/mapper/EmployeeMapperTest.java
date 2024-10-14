package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.dto.EmployeeDTO;
import com.hnguigu.mybatis.entity.Employee;
import com.hnguigu.mybatis.entity.EmployeeRole;
import com.hnguigu.mybatis.entity.Role;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmployeeMapperTest {

    @Test
    public void findByName() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            // 获取DepartmentMapper接口的代理对象。创建的代理对象实现了DepartmentMapper接口
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = employeeMapper.findByName("zhangsan");
            System.out.println(employee);

            System.out.println();


            List<Role> roleList = new ArrayList<>();
            Set<EmployeeRole> employeeRoles = employee.getEmployeeRoles();
            for (EmployeeRole employeeRole : employeeRoles) {
                Role role = employeeRole.getRole();
                roleList.add(role);
            }

            roleList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void findDTOsByName() {
        SqlSession sqlSession = null;
        try {

            sqlSession = MyBatisUtils.getSqlSession();

            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            List<EmployeeDTO> employeeDTOList = employeeMapper.findDTOsByName("zhangsan");

            employeeDTOList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}