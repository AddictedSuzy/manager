package com.zhiyue.manager.dao;

import com.zhiyue.manager.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByEmployeeId(String employeeId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    Users selectByUsernameAndPasswordRole(Users users);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}