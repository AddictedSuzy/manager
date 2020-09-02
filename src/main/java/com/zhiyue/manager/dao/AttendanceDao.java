package com.zhiyue.manager.dao;

import com.zhiyue.manager.entity.Attendance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    List<Attendance> selectByEmployeeId(String employeeId);

    List<Attendance> selectBySelective(Attendance record);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}