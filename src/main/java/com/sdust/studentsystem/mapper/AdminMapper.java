package com.sdust.studentsystem.mapper;

import com.sdust.studentsystem.entity.Admin;
import java.util.List;
import java.util.Map;

public interface AdminMapper {
    public List<Admin> selectAdmin(Map map);
    public List<Admin> selectAdmin2(Map map);
    public List<Admin> selectAdminList();
    public void addadmin(Map map);
    public void startuser(Map map);
    public void stopuser(Map map);
    public void deleteuser(Map map);
}
