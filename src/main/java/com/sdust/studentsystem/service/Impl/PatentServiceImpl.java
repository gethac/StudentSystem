package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Paper;
import com.sdust.studentsystem.entity.Patent;
import com.sdust.studentsystem.mapper.PaperMapper;
import com.sdust.studentsystem.mapper.PatentMapper;
import com.sdust.studentsystem.service.PaperService;
import com.sdust.studentsystem.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentMapper patentMapper;

    @Override
    public List<Patent> getpatentlistbystudentno(String studentno) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("studentno",studentno);
        List<Patent> list = patentMapper.getpatentlistbystudentno(map);
        return list;
    }

    @Override
    public void addpatent(String name, String firstsno, String secondsno, String date, String pno) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name",name);
        map.put("firstsno",firstsno);
        map.put("secondsno",secondsno);
        map.put("date",date);
        map.put("pno",pno);
        patentMapper.addpatent(map);
    }
}
