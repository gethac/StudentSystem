package com.sdust.studentsystem.service.Impl;

import com.sdust.studentsystem.entity.Admin;
import com.sdust.studentsystem.mapper.AdminMapper;
import com.sdust.studentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int checkAdmin(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", password);
        List<Admin> list = adminMapper.selectAdmin(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getUsername().equals(username) && list.get(0).getPassword().equals(password)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int checkAdmin(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        List<Admin> list = adminMapper.selectAdmin2(map);
        if (list == null || list.size() == 0) {
            return 0;
        } else {
            if (list.get(0).getUsername().equals(username)) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    @Override
    public List<Admin> getAdminList() {
        List<Admin> list = adminMapper.selectAdminList();
        return list;
    }

    @Override
    public void addadmin(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", password);
        adminMapper.addadmin(map);
    }

    @Override
    public void startuser(String username) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        adminMapper.startuser(map);
    }

    @Override
    public void stopuser(String username) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        adminMapper.stopuser(map);
    }

    @Override
    public void deleteuser(String username) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        adminMapper.deleteuser(map);
    }
}
