package com.zhiyue.manager.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * department
 * @author 
 */
@Data
public class Department implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 部门编号
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 领导名称
     */
    private String leaderName;

    private static final long serialVersionUID = 1L;
}