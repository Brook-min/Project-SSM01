package com.newer.util.sys;

import java.io.Serializable;
import java.util.List;

/**
 * JQuery-datatables 数据表格插件帮助类
 *
 * @author ZhangZihan
 */
public class DataTables implements Serializable {
    /**
     * 序列化保证对象唯一
     */
    private static final long serialVersionUID = 1L;
    private Integer draw;//datatables表格分页客户端默认带这个参数   服务端原路返回即可
    private Integer recordsTotal;// 数据库里总共记录数   (总记录数)
    private Integer recordsFiltered;// 过滤后的记录数   (总记录数)
    private List<?> data;// 表格展示的数据
    private String error;// 描述服务器出了问题后的友好提示

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "DataTable [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
                + ", data=" + data + ", error=" + error + "]";
    }

}
