package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Teacher;
import com.sdust.studentsystem.mapper.TeacherMapper;
import com.sdust.studentsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int checkTeacher(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", password);
        List<Teacher> list = teacherMapper.selectTeacher(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getName().equals(username) && list.get(0).getPassword().equals(password)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int checkTeacher(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        List<Teacher> list = teacherMapper.selectTeacher2(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getTno().equals(username)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public List<Teacher> selectTeacher(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        List<Teacher> list = teacherMapper.selectTeacher2(map);
        return list;
    }

    @Override
    public List<Teacher> getTeacherList() {
        List<Teacher> list = teacherMapper.selectTeacherList();
        return list;
    }

    @Override
    public List<Teacher> searchTeacher(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        List<Teacher> list = teacherMapper.searchTeacher(map);
        return list;
    }

    @Override
    public void startuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        teacherMapper.startuser(map);
    }

    @Override
    public void stopuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        teacherMapper.stopuser(map);
    }

    @Override
    public void deleteuser(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        teacherMapper.deleteuser(map);
    }
}
