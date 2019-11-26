package com.sdust.studentsystem.controller;

import com.sdust.studentsystem.entity.*;
import com.sdust.studentsystem.service.Impl.*;
import com.sdust.studentsystem.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author gyp
 * 导师主页的控制类
 */

@Controller
public class IndexTeacherController {

    private final AdminServiceImpl adminService;
    private final TeacherServiceImpl teacherService;
    private final StudentServiceImpl studentService;
    private final PaperServiceImpl paperService;
    private final PatentServiceImpl patentService;
    private final WeeklyServiceImpl weeklyService;

    @Autowired
    public IndexTeacherController(AdminServiceImpl adminService, TeacherServiceImpl teacherService, StudentServiceImpl studentService, PaperServiceImpl paperService, PatentServiceImpl patentService, WeeklyServiceImpl weeklyService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.paperService = paperService;
        this.patentService = patentService;
        this.weeklyService = weeklyService;
    }

    @RequestMapping("/indexteacher")
    public String indexteacher(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        } else if (flag.toString().equals("2")) {
            return "indexteacher";
        }
        return "login";
    }

    @RequestMapping(value = "/checkteacher", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean checkteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Teacher> list = teacherService.selectTeacher(username);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/studentlistbyteacher", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean studentlistbyteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Student> list = studentService.getStudentListByTeacher(username);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/setstudentno", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean setstudentno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        request.getSession().setAttribute("studentno", studentno);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/getstudentno", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getstudentno(HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        bean.setMsg(request.getSession().getAttribute("studentno").toString());
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/getpaperlistbystudentno", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getpaperlistbystudentno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Paper> list = paperService.getpaperlistbystudentno(studentno);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/getstudentnamebyno", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getstudentnamebyno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        String sname = studentService.getstudentnamebysno(studentno);
        bean.setMsg(sname);
        return bean;
    }

    @RequestMapping(value = "/getpatentlistbystudentno", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getpatentlistbystudentno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Patent> list = patentService.getpatentlistbystudentno(studentno);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/getweekly", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getweekly(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        Integer week = getWeek();
        Integer year = getYear();
        List<Weekly> nowlist = weeklyService.getweekly(studentno, String.valueOf(year), String.valueOf(week));
        week -= 1;
        if (week <= 0) {
            week = 53;
            year -= 1;
        }
        List<Weekly> lastweeklist = weeklyService.getweekly(studentno, String.valueOf(year), String.valueOf(week));
        WeeklyShow weeklyShow = new WeeklyShow();
        if(nowlist.size() != 0){
            String nowplan = nowlist.get(0).getPlan();
            weeklyShow.setNowplan(nowplan);
        }
        if(lastweeklist.size() != 0){
            String sno = lastweeklist.get(0).getSno();
            String plan = lastweeklist.get(0).getPlan();
            String completionstatus = lastweeklist.get(0).getCompletionstatus();
            String comment = lastweeklist.get(0).getComment();
            weeklyShow.setSno(sno);
            weeklyShow.setPlan(plan);
            weeklyShow.setCompletionstatus(completionstatus);
            weeklyShow.setComment(comment);
        }
        bean.setMsg(weeklyShow);
        return bean;
    }

    private Integer getYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    private Integer getWeek() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String date = format.format(d);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    @RequestMapping(value = "/subcomment", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean subcomment(String comment, String sno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        Integer week = getWeek();
        Integer year = getYear();
        week -= 1;
        if (week <= 0) {
            week = 53;
            year -= 1;
        }
        weeklyService.setcomment(comment, sno, String.valueOf(year), String.valueOf(week));
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/downfileindex-teacher", method = RequestMethod.GET)
    @ResponseBody
    public void downfileindex_teacher(String title, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            return;
        }
        String indexPath = paperService.getpaperindexpath(title);
        if (!indexPath.equals("")) {
            String path = "/static" + indexPath;
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            downFile(response, path, fileName);
        }
    }

    @RequestMapping(value = "/downfilepaper-teacher", method = RequestMethod.GET)
    @ResponseBody
    public void downfilepaper_teacher(String title, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("2")) {
            return;
        }
        String paperIndex = paperService.getpaperpaperpath(title);
        if (!paperIndex.equals("")) {
            String path = "/static" + paperIndex;
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            downFile(response, path, fileName);
        }
    }

    private void downFile(HttpServletResponse response, String path, String fileName) throws IOException {
        /** 将文件名称进行编码 */
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("content-type:octet-stream");
        /** 读取服务器端模板文件*/
        InputStream inputStream = IndexStudentController.class.getResourceAsStream(path);

        /** 将流中内容写出去 .*/
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }
}
