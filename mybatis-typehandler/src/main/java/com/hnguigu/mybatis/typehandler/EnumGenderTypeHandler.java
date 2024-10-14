package com.hnguigu.mybatis.typehandler;

import com.hnguigu.mybatis.entity.Gender;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个类型处理器只针对Gender枚举类型的映射
 *
 * @param <E>
 */
public class EnumGenderTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    public EnumGenderTypeHandler() {
    }

    /**
     * 给字段设置参数值
     * insert into mybatis_user values (null,'zhangsan',?)
     * 对于占位符设置参数
     *
     * @param ps        预编译语句对象
     * @param i         第几个？
     * @param parameter 真正的值（MALE）
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        // JDBC代码
        ps.setString(i, parameter.name());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String name = rs.getString(columnName);
        if (name != null) {
            // Gender这个枚举中   根据name变量的值获取Gender中对应的枚举类型的对象
            // name="MALE"意味着Gender枚举类型的MALE枚举对象
            // name="FEMALE"意味着Gender枚举的FEMALE枚举类型的对象
            return (E) Enum.valueOf(Gender.class, name);
        }
        return null;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String name = rs.getString(columnIndex);
        if (name != null) {
            return (E) Enum.valueOf(Gender.class, name);
        }
        return null;
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String name = cs.getString(columnIndex);
        if (name != null) {
            return (E) Enum.valueOf(Gender.class, name);
        }
        return null;
    }
}
