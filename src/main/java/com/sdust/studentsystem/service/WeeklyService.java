package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Weekly;

import java.util.List;

public interface WeeklyService {
    List<Weekly> getweekly(String studentno, String year, String week);

    void setcomment(String comment, String sno, String year, String week);

    void setcompletionstatus(String completionstatus, String sno, String year, String week);

    void setnowplan(String plan, String sno, String year, String week);
}
