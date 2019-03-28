package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String rolename;

    private String rolecode;

    private String description;

    private Date createtime;

    private Integer deletestatus;

    private Integer isdefault;

    private Integer resourceid;//资源id


    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
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

    public Integer getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", rolename=" + rolename + ", rolecode=" + rolecode + ", description=" + description
                + ", createtime=" + createtime + ", deletestatus=" + deletestatus + ", isdefault=" + isdefault + "]";
    }


}