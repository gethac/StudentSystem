package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Paper;
import java.util.List;

public interface PaperService {
     List<Paper> getpaperlistbystudentno(String studentno);
     void addpaper(String title,String firstsno,String secondsno,String publication,String year,String volume,String stage,String page,String index,String indexpath,String paperpath);
     String getpaperindexpath(String title);
     String getpaperpaperpath(String title);
}
