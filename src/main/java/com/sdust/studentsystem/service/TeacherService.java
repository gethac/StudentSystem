package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Teacher;

import java.util.List;

public interface TeacherService{
    int checkTeacher(String username,String password);
    int checkTeacher(String username);
    List<Teacher> selectTeacher(String username);
    List<Teacher> getTeacherList();
    List<Teacher> searchTeacher(String username);
    void startuser(String username);
    void stopuser(String username);
    void deleteuser(String username);
}
