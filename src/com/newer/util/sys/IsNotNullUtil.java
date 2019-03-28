package com.newer.util.sys;

import java.io.Serializable;

/**
 * 空值判断帮助类
 *
 * @author ZhangZihan
 */
public class IsNotNullUtil implements Serializable {
    /**
     * 序列化保证对象唯一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 空值判断
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        return obj != null && !"".equals(obj);
    }

    /**
     * 空值判断
     *
     * @param obj
     * @return
     */
    public static boolean isNotNullWithOr(Object obj) {
        return obj != null || !"".equals(obj);
    }

    /**
     * 为空值
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null || "null".equals(obj);
    }
}
