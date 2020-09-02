package com.zhiyue.manager.controller;

import com.zhiyue.manager.dao.AttendanceDao;
import com.zhiyue.manager.entity.Attendance;
import com.zhiyue.manager.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceDao attendanceDao;

    @RequestMapping("/queryAttendanceByEmployeeId")
    public CommonResult queryAttendanceByEmployeeId(Attendance attendance){
        List<Attendance> attendanceList = attendanceDao.selectByEmployeeId(attendance.getEmployeeId());
        return CommonResult.success(attendanceList);
    }

    /**
     * 打卡
     * @return
     */
    @RequestMapping("/addAttendance")
    public CommonResult addAttendance(Attendance attendance){
        if(attendance.getAttendanceEnd() != null){
            attendance.setAttendanceDate(attendance.getAttendanceEnd());
        }else if(attendance.getAttendanceStart() != null){
            attendance.setAttendanceStart(attendance.getAttendanceStart());
        }else {
            return CommonResult.fail();
        }
        Attendance query = new Attendance();
        query.setEmployeeId(attendance.getEmployeeId());
        List<Attendance> list = attendanceDao.selectBySelective(attendance);
        if(CollectionUtils.isEmpty(list)){
            attendanceDao.insertSelective(attendance);
        }else {
            Attendance current = list.get(0);
            current.setAttendanceStart(attendance.getAttendanceStart());
            current.setAttendanceEnd(attendance.getAttendanceEnd());
            current.setAttendanceDate(attendance.getAttendanceDate());
            attendanceDao.updateByPrimaryKeySelective(current);
        }

        return CommonResult.success();
    }
}
