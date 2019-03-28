package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 备案编号
     */
    private Integer keeponid;

    /**
     * 咨询师编号
     */
    private Integer consultationid;
    private String consultationname;
    /**
     * 咨询信息
     */
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date consultationtime;

    /**
     * 学员分类
     */
    private String studenttype;

    /**
     * 提醒时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date remindtime;

    /**
     * 咨询进度
     */
    private String process;

    private String markettype;


    public String getMarkettype() {
        return markettype;
    }

    public void setMarkettype(String markettype) {
        this.markettype = markettype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKeeponid() {
        return keeponid;
    }

    public void setKeeponid(Integer keeponid) {
        this.keeponid = keeponid;
    }

    public Integer getConsultationid() {
        return consultationid;
    }

    public void setConsultationid(Integer consultationid) {
        this.consultationid = consultationid;
    }

    public String getConsultationname() {
        return consultationname;
    }

    public void setConsultationname(String consultationname) {
        this.consultationname = consultationname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getConsultationtime() {
        return consultationtime;
    }

    public void setConsultationtime(Date consultationtime) {
        this.consultationtime = consultationtime;
    }

    public String getStudenttype() {
        return studenttype;
    }

    public void setStudenttype(String studenttype) {
        this.studenttype = studenttype;
    }

    public Date getRemindtime() {
        return remindtime;
    }

    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Consultation [id=" + id + ", keeponid=" + keeponid + ", consultationid=" + consultationid
                + ", consultationname=" + consultationname + ", content=" + content + ", consultationtime="
                + consultationtime + ", studenttype=" + studenttype + ", remindtime=" + remindtime + ", process="
                + process + "]";
    }


}