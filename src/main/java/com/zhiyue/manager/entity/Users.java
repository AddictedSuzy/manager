package com.zhiyue.manager.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * users
 * @author 
 */
@Data
public class Users implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 员工编码
     */
    private String employeeId;

    private static final long serialVersionUID = 1L;
}