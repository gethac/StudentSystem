package com.sdust.studentsystem.controller;

import com.sdust.studentsystem.entity.*;
import com.sdust.studentsystem.service.Impl.*;
import com.sdust.studentsystem.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author gyp
 * 导师主页的控制类
 */

@Controller
public class IndexStudentController {

    private final AdminServiceImpl adminService;
    private final TeacherServiceImpl teacherService;
    private final StudentServiceImpl studentService;
    private final PaperServiceImpl paperService;
    private final PatentServiceImpl patentService;
    private final WeeklyServiceImpl weeklyService;

    @Autowired
    public IndexStudentController(AdminServiceImpl adminService, TeacherServiceImpl teacherService, StudentServiceImpl studentService, PaperServiceImpl paperService, PatentServiceImpl patentService, WeeklyServiceImpl weeklyService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.paperService = paperService;
        this.patentService = patentService;
        this.weeklyService = weeklyService;
    }

    @RequestMapping("/indexstudent")
    public String indexstudent(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("username");
        Object flag = request.getSession().getAttribute("flag");
        if (user == null) {
            return "login";
        } else if (flag.toString().equals("3")) {
            return "indexstudent";
        }
        return "login";
    }

    @RequestMapping(value = "/checkstudent", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean checkteacher(String username, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Student> list = studentService.selectStudent(username);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/getpaperlistbystudentno-student", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getpaperlistbystudentno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Paper> list = paperService.getpaperlistbystudentno(studentno);
        bean.setMsg(list);
        return bean;
    }

    @RequestMapping(value = "/getstudentnamebyno-student", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getstudentnamebyno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        String sname = studentService.getstudentnamebysno(studentno);
        bean.setMsg(sname);
        return bean;
    }

    @RequestMapping(value = "/getpatentlistbystudentno-student", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getpatentlistbystudentno(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        List<Patent> list = patentService.getpatentlistbystudentno(studentno);
        bean.setMsg(list);
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

    @RequestMapping(value = "/subcompletionstatus", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean subcompletionstatus(String completionstatus, String sno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
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
        weeklyService.setcompletionstatus(completionstatus, sno, String.valueOf(year), String.valueOf(week));
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/subnowplan", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean subnowplan(String plan, String sno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        Integer week = getWeek();
        Integer year = getYear();
        weeklyService.setnowplan(plan, sno, String.valueOf(year), String.valueOf(week));
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/getweekly-student", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean getweekly(String studentno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
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
        if (nowlist.size() != 0) {
            String nowplan = nowlist.get(0).getPlan();
            weeklyShow.setNowplan(nowplan);
        }
        if (lastweeklist.size() != 0) {
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

    private final static String UPLOAD_PATH_PREFIX = "static/upload/";

    @RequestMapping(value = "/addpaper", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean addpaper(String title, String firstsno, String secondsno, String publication, String year, String volume, String stage, String page, String index, @RequestParam(value = "files", required = false) MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        File rootpath = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!rootpath.exists()) {
            rootpath = new File("");
        }
        String format = sdf.format(new Date());
        File file = new File(rootpath.getAbsolutePath(), UPLOAD_PATH_PREFIX + format);
        //判断是否存在该文件夹，若不存在则创建文件夹
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
        String[] path = new String[2];
        int i = 0;
        for (MultipartFile fileone : files) {
            String oldName = fileone.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            fileone.transferTo(newFile);
            String filePath = file.getAbsolutePath() + File.separator + newName;
            path[i] = filePath;
            i++;
        }
        String indexpath = path[0];
        String paperpath = path[1];
        paperService.addpaper(title, firstsno, secondsno, publication, year, volume, stage, page, index, indexpath, paperpath);
        bean.setCode(1);
        return bean;
    }

    @RequestMapping(value = "/downfileindex", method = RequestMethod.GET)
    @ResponseBody
    public void downfileindex(String title, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            return;
        }
        String indexPath = paperService.getpaperindexpath(title);
        int lastIndex = indexPath.lastIndexOf('\\');
        String tempPath = indexPath.substring(lastIndex + 1);
        if (!indexPath.equals("")) {
            String path = indexPath;
            String fileName = tempPath;
            downFile(response, path, fileName);
        }
    }

    @RequestMapping(value = "/downfilepaper", method = RequestMethod.GET)
    @ResponseBody
    public void downfilepaper(String title, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            return;
        }
        String paperIndex = paperService.getpaperpaperpath(title);
        if (!paperIndex.equals("")) {
            String path = paperIndex;
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            downFile(response, path, fileName);
        }
    }

    private void downFile(HttpServletResponse response, String path, String fileName) throws IOException {
        /** 将文件名称进行编码 */
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("content-type:octet-stream");
        /** 读取服务器端模板文件*/
        File f = new File(path);
        InputStream inputStream = new FileInputStream(f);
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

    @RequestMapping(value = "/addpatent", method = RequestMethod.POST)
    public @ResponseBody
    JsonBean addpatent(String name, String firstsno, String secondsno, String date, String pno, HttpServletRequest request) {
        JsonBean bean = new JsonBean();
        Object flag = request.getSession().getAttribute("flag");
        if (!flag.toString().equals("3")) {
            bean.setMsg("您没有权限访问该资源");
            return bean;
        }
        patentService.addpatent(name, firstsno, secondsno, date, pno);
        bean.setCode(1);
        return bean;
    }
}
