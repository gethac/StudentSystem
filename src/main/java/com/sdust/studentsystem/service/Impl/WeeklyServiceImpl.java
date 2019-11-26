package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Patent;
import com.sdust.studentsystem.entity.Weekly;
import com.sdust.studentsystem.mapper.PatentMapper;
import com.sdust.studentsystem.mapper.WeeklyMapper;
import com.sdust.studentsystem.service.PatentService;
import com.sdust.studentsystem.service.WeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeeklyServiceImpl implements WeeklyService {

    @Autowired
    private WeeklyMapper weeklyMapper;

    @Override
    public List<Weekly> getweekly(String studentno, String year, String week) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("studentno",studentno);
        map.put("year",year);
        map.put("week",week);
        return weeklyMapper.getWeekly(map);
    }

    @Override
    public void setcomment(String comment, String sno, String year, String week) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("comment",comment);
        map.put("sno",sno);
        map.put("year",year);
        map.put("week",week);
        weeklyMapper.setcomment(map);
    }

    @Override
    public void setcompletionstatus(String completionstatus, String sno, String year, String week) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("completionstatus",completionstatus);
        map.put("sno",sno);
        map.put("year",year);
        map.put("week",week);
        weeklyMapper.setcompletionstatus(map);
    }

    @Override
    public void setnowplan(String plan, String sno, String year, String week) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("plan",plan);
        map.put("sno",sno);
        map.put("year",year);
        map.put("week",week);
        weeklyMapper.setnowplan(map);
    }
}
