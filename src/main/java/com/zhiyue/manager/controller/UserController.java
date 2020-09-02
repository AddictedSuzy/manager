package com.zhiyue.manager.controller;

import com.zhiyue.manager.dao.PersonFilesDao;
import com.zhiyue.manager.dao.UsersDao;
import com.zhiyue.manager.entity.CommonResult;
import com.zhiyue.manager.entity.PersonFiles;
import com.zhiyue.manager.entity.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersDao usersDao;

    @Autowired
    PersonFilesDao personFilesDao;

    @RequestMapping("/login")
    public CommonResult login(Users users){
        if(users.getPassword() == null ||users.getUsername() == null || users.getRole() == null){
            return CommonResult.fail("请输入用户名密码");
        }
        Users loginUser = usersDao.selectByUsernameAndPasswordRole(users);
        if(loginUser == null){
            return CommonResult.fail("请输入正确的用户名密码");
        }

        return CommonResult.success(users);
    }

    @RequestMapping("/delete")
    public CommonResult deleteUser(Users users){
        if(users.getId() == null) {
            return CommonResult.fail("用户id不能为空");
        }
        usersDao.deleteByPrimaryKey(users.getId());
        return CommonResult.success();
    }

    @RequestMapping("/updateUser")
    public CommonResult updateUser(Users users){
        usersDao.updateByPrimaryKeySelective(users);
        return CommonResult.success();
    }

    @RequestMapping("/register")
    public CommonResult register(Users users){
        if(users.getRole() == null || users.getUsername() == null ||users.getPassword() == null || users.getEmployeeId() == null){
            return CommonResult.fail("输入参数不能为空");
        }

        PersonFiles personFiles = new PersonFiles();
        personFiles.setEmployeeId(users.getEmployeeId());
        List<PersonFiles> result = personFilesDao.selectPersonFiles(personFiles);
        if(CollectionUtils.isEmpty(result)){
            return CommonResult.fail("请确认员工编号");
        }
        usersDao.insert(users);

        return CommonResult.success();
    }


}
