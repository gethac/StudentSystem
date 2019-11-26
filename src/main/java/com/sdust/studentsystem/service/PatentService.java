package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Patent;

import java.util.Date;
import java.util.List;

public interface PatentService {
     List<Patent> getpatentlistbystudentno(String studentno);
     void addpatent(String name, String firstsno, String secondsno, String date, String pno);
}
