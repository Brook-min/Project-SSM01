package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 盐
     */
    private String salt;
    private String description;
    /**
     * 锁定
     */
    private Integer locked;
    private Date createtime;
    /**
     * 删除状态 用于做假删除
     */
    private Integer deletestatus;
    private String sex;
    private Integer age;
    /**
     * 学历
     */
    private String education;
    private String telephone;
    private String email;
    private String province;
    private String city;
    private String area;
    private String address;
    /**
     * 上级编号
     */
    private Integer upno;
    /**
     * 上级名称
     */
    private String upname;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门编号
     */
    private Integer deptno;

    private Dept dept;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    //用于树名
    public Integer getId() {
        return id;
    }

    public String getUpname() {
        return upname;
    }

    public void setUpname(String upname) {
        this.upname = upname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUpno() {
        return upno;
    }

    public void setUpno(Integer upno) {
        this.upno = upno;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
                + ", salt=" + salt + ", description=" + description + ", locked=" + locked + ", createtime="
                + createtime + ", deletestatus=" + deletestatus + ", sex=" + sex + ", age=" + age + ", education="
                + education + ", telephone=" + telephone + ", email=" + email + ", province=" + province + ", city="
                + city + ", area=" + area + ", address=" + address + ", upno=" + upno + ", deptno=" + deptno + "]";
    }


}