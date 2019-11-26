package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Paper;

import java.util.List;
import java.util.Map;

public interface PaperMapper {
    public List<Paper> getpaperlistbystudentno(Map map);
    public void addpaper(Map map);
    public List<Paper> getpaperbytitle(Map map);
}
