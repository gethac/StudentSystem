package com.sdust.studentsystem.controller;

import com.sdust.studentsystem.service.Impl.AdminServiceImpl;
import com.sdust.studentsystem.service.Impl.StudentServiceImpl;
import com.sdust.studentsystem.service.Impl.TeacherServiceImpl;
import com.sdust.studentsystem.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final StudentServiceImpl studentService;
    private final AdminServiceImpl adminService;
    private final TeacherServiceImpl TeacherService;

    @Autowired
    public LoginController(StudentServiceImpl studentService, AdminServiceImpl adminService, TeacherServiceImpl TeacherService) {
        this.studentService = studentService;
        this.adminService = adminService;
        this.TeacherService = TeacherService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean check(String username, String password, HttpServletRequest request) {
        int result = 0;
        JsonBean bean = new JsonBean();
        result = checkStudent(username, password);
        request.getSession().setMaxInactiveInterval(60 * 60 * 24);
        if (result == 1) {
            bean.setCode(1);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("flag", "3");
            return bean;
        }
        result = checkTeacher(username, password);
        if (result == 1) {
            bean.setCode(2);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("flag", "2");
            return bean;
        }
        result = checkAdmin(username, password);
        if (result == 1) {
            bean.setCode(3);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("flag", "1");
            return bean;
        }
        if (result == 0) {
            bean.setCode(0);
            bean.setMsg("用户名或密码错误，请重新输入");
        }
        return bean;
    }

    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean checkuser(String username) {
        int result = 0;
        JsonBean bean = new JsonBean();
        result = checkStudent(username);
        if (result == 1) {
            bean.setCode(1);
            return bean;
        }
        result = checkTeacher(username);
        if (result == 1) {
            bean.setCode(2);
            return bean;
        }
        result = checkAdmin(username);
        if (result == 1) {
            bean.setCode(3);
            return bean;
        }
        if (result == 0) {
            bean.setCode(0);
        }
        return bean;
    }

    private int checkStudent(String username, String password) {
        return studentService.checkStudent(username, password);
    }

    private int checkAdmin(String username, String password) {
        return adminService.checkAdmin(username, password);
    }

    private int checkTeacher(String username, String password) {
        return TeacherService.checkTeacher(username, password);
    }

    private int checkStudent(String username) {
        return studentService.checkStudent(username);
    }

    private int checkAdmin(String username) {
        return adminService.checkAdmin(username);
    }

    private int checkTeacher(String username) {
        return TeacherService.checkTeacher(username);
    }
}
