package com.sdust.studentsystem.entity;

public class WeeklyShow {
    private String sno;
    private String nowplan;
    private String plan;
    private String completionstatus;
    private String comment;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getNowplan() {
        return nowplan;
    }

    public void setNowplan(String nowplan) {
        this.nowplan = nowplan;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
