package com.newer.util.sys;

import java.io.Serializable;

/**
 * 条件分页帮助类
 *
 * @author ZhangZihan
 */
public class PageFilter implements Serializable {

    /**
     * 序列化保证对象唯一
     */
    private static final long serialVersionUID = 1L;
    private Integer draw;// datatables表格分页客户端默认带这个参数 服务端原路返回即可
    private Integer start;// 第一条数据的起始位置，比如0代表第一条数据
    private Integer length;// 每页显示的条数
    private String sort; // 升序还是降序
    private String sortName;// 排序字段名

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "PageFilter [draw=" + draw + ", start=" + start + ", length=" + length + ", sort=" + sort + ", sortName="
                + sortName + "]";
    }

}
