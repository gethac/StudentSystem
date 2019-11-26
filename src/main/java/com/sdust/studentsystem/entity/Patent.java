package com.sdust.studentsystem.entity;

import java.util.Date;

public class Patent {
    private Integer id;
    private String name;
    private String firstsno;
    private String secondsno;
    private String date;
    private String pno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstsno() {
        return firstsno;
    }

    public void setFirstsno(String firstsno) {
        this.firstsno = firstsno;
    }

    public String getSecondsno() {
        return secondsno;
    }

    public void setSecondsno(String secondsno) {
        this.secondsno = secondsno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }
}
