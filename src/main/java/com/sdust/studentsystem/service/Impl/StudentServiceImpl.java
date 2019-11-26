package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Student;
import com.sdust.studentsystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements com.sdust.studentsystem.service.StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int checkStudent(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sno", username);
        map.put("password", password);
        List<Student> list = studentMapper.selectStudent(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getSno().equals(username) && list.get(0).getPassword().equals(password)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int checkStudent(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sno", username);
        List<Student> list = studentMapper.selectStudent2(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getSno().equals(username)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public List<Student> selectStudent(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sno", username);
        List<Student> list = studentMapper.selectStudent2(map);
        return list;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> list = studentMapper.selectStudentList();
        return list;
    }

    @Override
    public List<Student> getStudentListByTeacher(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("teachername", username);
        List<Student> list = studentMapper.selectStudentListByTeacher(map);
        return list;
    }

    @Override
    public String getstudentnamebysno(String sno) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sno", sno);
        List<Student> list = studentMapper.selectStudent2(map);
        return list.get(0).getSname();
    }

    @Override
    public void startuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        studentMapper.startuser(map);
    }

    @Override
    public void stopuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        studentMapper.stopuser(map);
    }

    @Override
    public void deleteuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        studentMapper.deleteuser(map);
    }
}
