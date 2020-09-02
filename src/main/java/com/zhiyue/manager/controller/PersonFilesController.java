package com.zhiyue.manager.controller;

import com.zhiyue.manager.dao.PersonFilesDao;
import com.zhiyue.manager.dao.UsersDao;
import com.zhiyue.manager.entity.CommonResult;
import com.zhiyue.manager.entity.PersonFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonFilesController {

    @Autowired
    PersonFilesDao personFilesDao;

    @Autowired
    UsersDao usersDao;

    @RequestMapping("/search")
    public CommonResult search(PersonFiles personFiles){
        List<PersonFiles> personFilesList = personFilesDao.selectPersonFiles(personFiles);
        return CommonResult.success(personFilesList);
    }

    @RequestMapping("/modify")
    public CommonResult modify(PersonFiles personFiles){
        personFilesDao.updateByPrimaryKeySelective(personFiles);
        return CommonResult.success();
    }

    @RequestMapping("/delete")
    @Transactional
    public CommonResult delete(PersonFiles personFiles){
        if(personFiles.getId() == null){
            return CommonResult.fail("id不能为空");
        }
        PersonFiles current = personFilesDao.selectByPrimaryKey(personFiles.getId());
        String employeeId= current.getEmployeeId();
        personFilesDao.deleteByPrimaryKey(personFiles.getId());
        usersDao.deleteByEmployeeId(employeeId);

        return CommonResult.success();
    }

    @RequestMapping("/addPersonFiles")
    public CommonResult addPersonFiles(PersonFiles personFiles){
        PersonFiles current = personFilesDao.selectByPrimaryKey(personFiles.getId());
        if (current != null){
            return CommonResult.fail("已存在相同的用户");
        }
        personFilesDao.insertSelective(personFiles);

        return CommonResult.success();
    }


}
