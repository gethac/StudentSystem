package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {
    int checkStudent(String username,String password);
    int checkStudent(String username);
    List<Student> selectStudent(String username);
    List<Student> getStudentList();
    List<Student> getStudentListByTeacher(String username);
    String getstudentnamebysno(String sno);
    void startuser(String username);
    void stopuser(String username);
    void deleteuser(String username);
}
