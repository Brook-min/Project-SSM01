package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class Base implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String value;

    /**
     * 上级编号
     */
    private Integer pid;

    private String description;

    private Date createtime;

    private String deletestatus;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(String deletestatus) {
        this.deletestatus = deletestatus;
    }
}