package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gyp
 *
 */
public interface StudentMapper {
    public List<Student> selectStudent(Map map);
    public List<Student> selectStudent2(Map map);
    public List<Student> selectStudentList();
    public List<Student> selectStudentListByTeacher(Map map);
    public void startuser(Map map);
    public void stopuser(Map map);
    public void deleteuser(Map map);
}
