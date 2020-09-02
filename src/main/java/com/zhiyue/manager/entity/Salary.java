package com.zhiyue.manager.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * salary
 * @author 
 */
@Data
public class Salary implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 工资id
     */
    private Integer salaryId;

    /**
     * 员工id
     */
    private String employeeId;

    private String employeeName;

    /**
     * 基本工资
     */
    private Integer basicSalary;

    /**
     * 奖金
     */
    private Integer reward;

    /**
     * 罚金
     */
    private Integer forfeit;

    /**
     * 发放时间
     */
    private Date payTime;

    private static final long serialVersionUID = 1L;
}