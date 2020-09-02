package com.zhiyue.manager.controller;

import com.zhiyue.manager.dao.SalaryDao;
import com.zhiyue.manager.entity.CommonResult;
import com.zhiyue.manager.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryDao salaryDao;

    @RequestMapping("/search")
    public CommonResult search(Salary salary){
        List<Salary> salaryList = salaryDao.selectBySalary(salary);
        return CommonResult.success(salaryList);
    }

    @RequestMapping("/modify")
    public CommonResult modify(Salary salary){
        salaryDao.updateByPrimaryKeySelective(salary);

        return CommonResult.success();
    }
}
