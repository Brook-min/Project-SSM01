package com.newer.util.sys;

import java.util.List;
import java.util.Set;

import com.newer.pojo.sys.Resource;

/**
 * 记录当前用户信息及资源
 *
 * @author liukang
 */
public class UserSession implements java.io.Serializable {

    /**
     * 序列化保证对象唯一
     */
    private static final long serialVersionUID = 1L;
    private Integer id;// 用户ID
    private String username;// 登录名
    private String realname;// 真实姓名
    private String ip;// 用户IP

    /**
     * 用户可以访问的资源地址列表
     */
    private Set<String> resourceList;

    /**
     * 左侧菜单栏
     */
    private List<Resource> resources;

    /**
     * 用户所拥有的角色名称
     */
    private Set<String> roleCodes;


    public Set<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(Set<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Set<String> getResourceList() {
        return resourceList;
    }

    public void setResourceList(Set<String> resourceList) {
        this.resourceList = resourceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    @Override
    public String toString() {
        return "UserSession [id=" + id + ", username=" + username + ", realname=" + realname + ", ip=" + ip
                + ", resourceList=" + resourceList + "]";
    }


}
