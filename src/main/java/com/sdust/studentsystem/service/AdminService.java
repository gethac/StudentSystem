package com.sdust.studentsystem.service;

import com.sdust.studentsystem.entity.Admin;

import java.util.List;

public interface AdminService {
     int checkAdmin(String username,String password);
     int checkAdmin(String username);
     List<Admin> getAdminList();
     void addadmin(String username,String password);
     void startuser(String username);
     void stopuser(String username);
     void deleteuser(String username);
}
