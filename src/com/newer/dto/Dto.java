package com.newer.dto;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 作者：周叶云
 * @version 创建时间：2018-10-12 下午4:24:01 没有使用Example查询时，使用
 * 类说明:查询排序，bootstrap默认提交的参数为：sort，order
 */
public class Dto implements Serializable {
    private String sort;
    private String order;

    public String getSort() {
        if (this.sort != null) {
            // empId变成 emp_id
            this.sort = this.sort.substring(this.sort.lastIndexOf(".") + 1);
            Matcher matcher = Pattern.compile("[A-Z]").matcher(this.sort);
            while (matcher.find()) {
                this.sort = this.sort.replace(matcher.group(), "_"
                        + matcher.group().toLowerCase());

            }
        }
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

}
