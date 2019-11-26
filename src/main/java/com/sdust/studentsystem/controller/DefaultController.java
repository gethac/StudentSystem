package com.sdust.studentsystem.controller;

import com.sdust.studentsystem.vo.JsonBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gyp
 * 各种子窗口的控制类
 */

@Controller
public class DefaultController {

    /**
     *  以下为通用页面，任何人都可访问
     */

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "login";
    }


    @RequestMapping(value = "/getusername", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getusername(HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object user = request.getSession().getAttribute("username");
        bean.setMsg(user.toString());
        return bean;
    }

    /**
     *  以下为管理员页面，flag为1才可访问
     */

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("1")){
            return "welcome";
        }
        return "login";
    }


    @RequestMapping("/admin-add")
    public String admin_add(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("1")){
            return "admin-add";
        }
        return "login";
    }

    @RequestMapping("/student-list")
    public String student_list(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("1")){
            return "student-list";
        }
        return "login";
    }

    @RequestMapping("/teacher-list")
    public String teacher_list(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("1")){
            return "teacher-list";
        }
        return "login";
    }

    @RequestMapping("/admin-list")
    public String admin_list(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("1")){
            return "admin-list";
        }
        return "login";
    }

    /**
     *  以下为导师页面，flag为2才可访问
     */

    @RequestMapping("/welcome1")
    public String welcome1(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("2")){
            return "welcome1";
        }
        return "login";
    }

    @RequestMapping("/student-direct")
    public String student_direct(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("2")){
            return "student-direct";
        }
        return "login";
    }

    @RequestMapping("/student-achievement")
    public String student_achievement(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("2")){
            return "student-achievement";
        }
        return "login";
    }

    @RequestMapping("/student-weeklycheck")
    public String student_weeklycheck(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("2")){
            return "student-weeklycheck";
        }
        return "login";
    }

    /**
     *  以下为学生页面，flag为3才可访问
     */

    @RequestMapping("/welcome2")
    public String welcome2(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "welcome2";
        }
        return "login";
    }

    @RequestMapping("/student-paper")
    public String student_paper(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "student-paper";
        }
        return "login";
    }

    @RequestMapping("/student-patent")
    public String student_patent(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "student-patent";
        }
        return "login";
    }

    @RequestMapping("/student-weekly")
    public String student_weekly(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "student-weekly";
        }
        return "login";
    }

    @RequestMapping("/paper-add")
    public String paper_add(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "paper-add";
        }
        return "login";
    }

    @RequestMapping("/patent-add")
    public String patent_add(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        }
        else if(flag.toString().equals("3")){
            return "patent-add";
        }
        return "login";
    }

}
