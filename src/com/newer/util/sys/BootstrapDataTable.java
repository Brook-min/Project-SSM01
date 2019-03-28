package com.newer.util.sys;

import java.util.List;

/**
 * Bootstrap-table工具类
 *
 * @author ZhangZihan
 */
public class BootstrapDataTable {
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 条件筛选分页后数据
     */
    private List<?> rows;
    /**
     * 排序字段
     */
    private String sort;
    /**
     * 升序或者降序 asc desc
     */
    private String order;
    /**
     * 页码
     */
    private Integer offset;
    /**
     * 页容量
     */
    private Integer limit;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "BootstrapDataTable [total=" + total + ", rows=" + rows + ", sort=" + sort + ", order=" + order
                + ", offset=" + offset + ", limit=" + limit + "]";
    }


}
