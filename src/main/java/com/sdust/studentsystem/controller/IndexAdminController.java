package com.sdust.studentsystem.controller;

import com.sdust.studentsystem.entity.Admin;
import com.sdust.studentsystem.entity.Student;
import com.sdust.studentsystem.entity.Teacher;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author gyp
 * 管理员主页的控制类
 */

@Controller
public class IndexAdminController {

    private final AdminServiceImpl adminService;
    private final TeacherServiceImpl teacherService;
    private final StudentServiceImpl studentService;

    @Autowired
    public IndexAdminController(AdminServiceImpl adminService, TeacherServiceImpl teacherService, StudentServiceImpl studentService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @RequestMapping("/indexadmin")
    public String indexadmin(HttpServletRequest request, HttpServletResponse response) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        } else if (flag.toString().equals("1")) {
            return "indexadmin";
        }
        return "login";
    }

    @RequestMapping(value = "/adminlist", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean adminlist(HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Admin> adminList = adminService.getAdminList();
        bean.setMsg(adminList);
        return bean;
    }

    @RequestMapping(value = "/teacherlist", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean teacherlist(HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Teacher> teacherList = teacherService.getTeacherList();
        bean.setMsg(teacherList);
        return bean;
    }

    @RequestMapping(value = "/studentlist", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean studentlist(HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Student> studentList = studentService.getStudentList();
        bean.setMsg(studentList);
        return bean;
    }

    @RequestMapping(value = "/addadmin", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean addadmin(String username, String password, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        adminService.addadmin(username, password);
        bean.setMsg("添加成功");
        return bean;
    }

    @RequestMapping(value = "/stopadmin", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean stopadmin(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        adminService.stopuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/startadmin", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean startadmin(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        adminService.startuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/stopstudent", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean stopstudent(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        studentService.stopuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/startstudent", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean startstudent(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        studentService.startuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/stopteacher", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean stopteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        teacherService.stopuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/startteacher", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean startteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        teacherService.startuser(username);
        bean.setCode(1);
        return bean;
    }


    @RequestMapping(value = "/deleteadmin", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean deleteadmin(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        adminService.deleteuser(username);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/deletestudent", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean deletestudent(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        studentService.deleteuser(username);
        bean.setCode(1);
        return bean;
    }


    @RequestMapping(value = "/deleteteacher", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean deleteteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("1")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        teacherService.deleteuser(username);
        bean.setCode(1);
        return bean;
    }
}
