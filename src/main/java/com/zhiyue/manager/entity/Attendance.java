package com.zhiyue.manager.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * attendance
 * @author 
 */
@Data
public class Attendance implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 员工id
     */
    private String employeeId;

    /**
     * 下班打卡时间
     */
    private Date attendanceEnd;

    /**
     * 上班打卡时间
     */
    private Date attendanceStart;

    /**
     * 打卡日期
     */
    private Date attendanceDate;

    private static final long serialVersionUID = 1L;
}