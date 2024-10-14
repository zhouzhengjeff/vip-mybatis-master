package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.dto.UserQueryDTO;
import com.hnguigu.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User findById(Integer id);

    List<User> findByQueryDTO(UserQueryDTO userQueryDTO);

    void update(User user);

    /**
     * 批量删除
     * @param ids 编号数组
     */
    void deleteByIds(Integer[] ids);

    void deleteByIdList(List<Integer> ids);

    void save(User user);
}
