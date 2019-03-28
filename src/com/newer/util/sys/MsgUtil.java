package com.newer.util.sys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息帮助类
 *
 * @author ZhangZihan
 */
public class MsgUtil implements Serializable {
    /**
     * 序列化保证对象唯一
     */
    private static final long serialVersionUID = 1L;
    private String msg;// 提示消息
    private boolean flag;// 是否成功
    private Map<String, Object> data = new HashMap<String, Object>(); // 用户要返回的浏览器的数据

    /**
     * 返回验证状态和信息
     *
     * @param flag
     * @param msg
     * @return
     */
    public static MsgUtil result(boolean flag, String msg) {
        MsgUtil msgUtil = new MsgUtil();
        msgUtil.setMsg(msg);
        msgUtil.setFlag(flag);
        return msgUtil;
    }

    /**
     * 用于页面带参数返回 比如： return MsgUtil.result(xx,xx).put(xx,xx);
     *
     * @param key
     * @param value
     * @return
     */
    public MsgUtil put(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MsgUtil [msg=" + msg + ", flag=" + flag + ", data=" + data + "]";
    }

}
