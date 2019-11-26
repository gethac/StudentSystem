package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Teacher;
import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    public List<Teacher> selectTeacher(Map map);
    public List<Teacher> selectTeacher2(Map map);
    public List<Teacher> selectTeacherList();
    public List<Teacher> searchTeacher(Map map);
    public void startuser(Map map);
    public void stopuser(Map map);
    public void deleteuser(Map map);
}
