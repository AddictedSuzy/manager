package com.zhiyue.manager.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * person_files
 * @author 
 */
@Data
public class PersonFiles implements Serializable {
    /**
     * 记录编号
     */
    private Integer id;

    /**
     * 员工编号
     */
    private String employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 职务
     */
    private String position;

    /**
     * 民族
     */
    private String national;

    /**
     * 学历
     */
    private String education;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 工作性质
     */
    private String work;

    private static final long serialVersionUID = 1L;
}