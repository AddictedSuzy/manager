package com.zhiyue.manager.dao;

import com.zhiyue.manager.entity.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    List<Salary> selectBySalary(Salary record);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}