package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Keepon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String studentname;

    /**
     * 信息来源
     */
    private String infosource;

    private Integer age;

    private String marketer;

    private String sex;

    /**
     * 关联人
     */
    private String associates;

    private String nameremark;

    /**
     * 关联人关系
     */
    private String relationship;

    private String qq;

    private String telephone;

    /**
     * 所在区域
     */

    private String school;

    /**
     * 体系
     */
    private String system;

    /**
     * 专业
     */
    private String major;

    private String education;

    /**
     * 咨询师
     */
    private String consultationperson;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consultationtime;

    /**
     * 咨询进度
     */
    private String consultationprocess;

    /**
     * 联系状态
     */
    private String contactstate;

    /**
     * 提醒时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date remindtime;

    /**
     * 咨询分类
     */
    private String consultationtype;

    /**
     * 市场分类
     */
    private String markettype;

    private String description;

    /**
     * 备案人
     */
    private String keeponperson;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date keepontime;

    /**
     * 上门时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visitdate;

    private String deletestatus;

    /**
     * 目前状态
     */
    private String nowstatus;

    /**
     * 招生主管
     */
    private String supervisor;

    /**
     * 培训形式
     */
    private String trainingtype;

    /**
     * 订座班级
     */
    private String bookclass;

    private String schoolarea;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date booktime;

    /**
     * 上门时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visiteddate;

    /**
     * 转上门备注
     */
    private String visitdesc;

    /**
     * 进班时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shifttime;

    /**
     * 进班班级
     */
    private String shiftclass;

    private Float paymoney;

    /**
     * 班主任
     */
    private String headmaster;

    /**
     * 咨询信息对象
     */
    private Consultation consultation;

    /**
     * 咨询信息集合
     */
    private List<Consultation> consultations;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String area;


    /**
     * 备案人id
     */
    private Integer keeponid;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getInfosource() {
        return infosource;
    }

    public void setInfosource(String infosource) {
        this.infosource = infosource;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMarketer() {
        return marketer;
    }

    public void setMarketer(String marketer) {
        this.marketer = marketer;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAssociates() {
        return associates;
    }

    public void setAssociates(String associates) {
        this.associates = associates;
    }

    public String getNameremark() {
        return nameremark;
    }

    public void setNameremark(String nameremark) {
        this.nameremark = nameremark;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getConsultationperson() {
        return consultationperson;
    }

    public void setConsultationperson(String consultationperson) {
        this.consultationperson = consultationperson;
    }

    public Date getConsultationtime() {
        return consultationtime;
    }

    public void setConsultationtime(Date consultationtime) {
        this.consultationtime = consultationtime;
    }

    public String getConsultationprocess() {
        return consultationprocess;
    }

    public void setConsultationprocess(String consultationprocess) {
        this.consultationprocess = consultationprocess;
    }

    public String getContactstate() {
        return contactstate;
    }

    public void setContactstate(String contactstate) {
        this.contactstate = contactstate;
    }

    public Date getRemindtime() {
        return remindtime;
    }

    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }

    public String getConsultationtype() {
        return consultationtype;
    }

    public void setConsultationtype(String consultationtype) {
        this.consultationtype = consultationtype;
    }

    public String getMarkettype() {
        return markettype;
    }

    public void setMarkettype(String markettype) {
        this.markettype = markettype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeeponperson() {
        return keeponperson;
    }

    public void setKeeponperson(String keeponperson) {
        this.keeponperson = keeponperson;
    }

    public Date getKeepontime() {
        return keepontime;
    }

    public void setKeepontime(Date keepontime) {
        this.keepontime = keepontime;
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public String getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(String deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getNowstatus() {
        return nowstatus;
    }

    public void setNowstatus(String nowstatus) {
        this.nowstatus = nowstatus;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTrainingtype() {
        return trainingtype;
    }

    public void setTrainingtype(String trainingtype) {
        this.trainingtype = trainingtype;
    }

    public String getBookclass() {
        return bookclass;
    }

    public void setBookclass(String bookclass) {
        this.bookclass = bookclass;
    }

    public String getSchoolarea() {
        return schoolarea;
    }

    public void setSchoolarea(String schoolarea) {
        this.schoolarea = schoolarea;
    }

    public Date getBooktime() {
        return booktime;
    }

    public void setBooktime(Date booktime) {
        this.booktime = booktime;
    }

    public Date getVisiteddate() {
        return visiteddate;
    }

    public void setVisiteddate(Date visiteddate) {
        this.visiteddate = visiteddate;
    }

    public String getVisitdesc() {
        return visitdesc;
    }

    public void setVisitdesc(String visitdesc) {
        this.visitdesc = visitdesc;
    }

    public Date getShifttime() {
        return shifttime;
    }

    public void setShifttime(Date shifttime) {
        this.shifttime = shifttime;
    }

    public String getShiftclass() {
        return shiftclass;
    }

    public void setShiftclass(String shiftclass) {
        this.shiftclass = shiftclass;
    }

    public Float getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Float paymoney) {
        this.paymoney = paymoney;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public Integer getKeeponid() {
        return keeponid;
    }

    public void setKeeponid(Integer keeponid) {
        this.keeponid = keeponid;
    }

}