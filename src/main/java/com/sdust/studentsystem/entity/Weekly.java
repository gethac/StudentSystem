package com.sdust.studentsystem.entity;

public class Weekly {
    private Integer id;
    private String sno;
    private String plan;
    private String completionstatus;
    private String year;
    private Integer week;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCompletionstatus() {
        return completionstatus;
    }

    public void setCompletionstatus(String completionstatus) {
        this.completionstatus = completionstatus;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
