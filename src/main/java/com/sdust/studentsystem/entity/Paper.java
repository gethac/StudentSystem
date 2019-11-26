package com.sdust.studentsystem.entity;

public class Paper {
    private Integer id;
    private String title;
    private String firstsno;
    private String secondsno;
    private String publication;
    private String year;
    private String volume;
    private String stage;
    private String page;
    private String ind;
    private String indexpath;
    private String paperpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getIndexpath() {
        return indexpath;
    }

    public void setIndexpath(String indexpath) {
        this.indexpath = indexpath;
    }

    public String getPaperpath() {
        return paperpath;
    }

    public void setPaperpath(String paperpath) {
        this.paperpath = paperpath;
    }
}
