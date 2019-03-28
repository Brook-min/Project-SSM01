package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门实体类
 *
 * @author 卿超
 */
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String deptname;

    private String description;

    private String address;

    //用于树名
    private String name;

    /**
     * 上级部门编号
     */
    private Integer pid;

    /**
     * 上级部门名称
     */
    private String pName;

    private String icon;

    private Date createtime;

    private Integer deletestatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    @Override
    public String toString() {
        return "Dept [id=" + id + ", deptname=" + deptname + ", description=" + description + ", address=" + address
                + ", pid=" + pid + ", icon=" + icon + ", createtime=" + createtime + ", deletestatus=" + deletestatus
                + "]";
    }
}