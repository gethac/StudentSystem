package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Weekly;
import java.util.List;
import java.util.Map;

public interface WeeklyMapper {
    public List<Weekly> getWeekly(Map map);
    public void setcomment(Map map);
    public void setcompletionstatus(Map map);
    public void setnowplan(Map map);
}
