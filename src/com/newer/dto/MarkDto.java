package com.newer.dto;


/**
 * @author 作者：周叶云
 * @version 创建时间：2018-10-10 下午5:11:57 类说明
 */
public class MarkDto extends Dto {
    private Integer stuId;
    private String stuName;
    private Integer subId;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }


}
