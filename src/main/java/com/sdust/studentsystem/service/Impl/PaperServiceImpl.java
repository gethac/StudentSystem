package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Paper;
import com.sdust.studentsystem.mapper.PaperMapper;
import com.sdust.studentsystem.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<Paper> getpaperlistbystudentno(String studentno) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("studentno",studentno);
        List<Paper> list = paperMapper.getpaperlistbystudentno(map);
        return list;
    }

    @Override
    public void addpaper(String title, String firstsno, String secondsno, String publication, String year, String volume, String stage, String page, String index, String indexpath, String paperpath) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("title",title);
        map.put("firstsno",firstsno);
        map.put("secondsno",secondsno);
        map.put("publication",publication);
        map.put("year",year);
        map.put("volume",volume);
        map.put("stage",stage);
        map.put("page",page);
        map.put("index",index);
        map.put("indexpath",indexpath);
        map.put("paperpath",paperpath);
        paperMapper.addpaper(map);
    }

    @Override
    public String getpaperindexpath(String title) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("title",title);
        List<Paper> list =  paperMapper.getpaperbytitle(map);
        String indexPath = "";
        if(list.size() != 0){
            indexPath = list.get(0).getIndexpath();
        }
        return indexPath;
    }

    @Override
    public String getpaperpaperpath(String title) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("title",title);
        List<Paper> list =  paperMapper.getpaperbytitle(map);
        String paperPath = "";
        if(list.size() != 0){
            paperPath = list.get(0).getPaperpath();
        }
        return paperPath;
    }
}
