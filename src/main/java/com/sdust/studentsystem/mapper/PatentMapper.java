package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Patent;
import java.util.List;
import java.util.Map;

public interface PatentMapper {
    public List<Patent> getpatentlistbystudentno(Map map);
    public void addpatent(Map map);
}
