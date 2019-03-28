package com.newer.pojo.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String resourcecode;

    /**
     * 资源路径
     */
    private String url;

    private String description;

    private String icon;
    /**
     * 上级编号
     */
    private Integer pid;

    private String pName;

    /**
     * 序号 用于排序
     */
    private Integer seq;

    private String status;

    private String type;

    private Date createtime;

    private List<Resource> resources;


    public Resource() {
        super();
    }

    public Resource(Integer id, String name, String reourcecode, String url, String description, String icon,
                    Integer pid, Integer seq, String status, String type, Date createtime) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.icon = icon;
        this.pid = pid;
        this.seq = seq;
        this.status = status;
        this.type = type;
        this.createtime = createtime;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources2) {
        this.resources = resources2;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourcecode() {
        return resourcecode;
    }

    public void setResourcecode(String resourcecode) {
        this.resourcecode = resourcecode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Resource [id=" + id + ", name=" + name + ", resourcecode=" + resourcecode + ", url=" + url
                + ", description=" + description + ", icon=" + icon + ", pid=" + pid + ", seq=" + seq + ", status="
                + status + ", type=" + type + ", createtime=" + createtime + "]";
    }

}