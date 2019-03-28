package com.newer.util.sys;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 条件查询工具类
 *
 * @author ZhangZihan
 */
public class Condition {

    /**
     * 用户查询条件
     */
/*	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userStartTime;// 开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userEndTime; // 结束时间
*/
    private String userSearch; // 用户名称、电话、邮箱

    /**
     * 资源查询条件
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resourceStartTime;// 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resourceEndTime; // 结束时间
    private String resourceSearch;// 资源名称、类型

    /**
     * 角色查询条件
     */
    private String roleName;// 角色名

    /**
     * 基础信息查询条件
     */
    private String baseName;//基础信息名称
    /**
     * 部门查询条件
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deptStartTime; // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deptEndTime;// 结束时间
    private String deptSearch; // 部门名称、地址

    /**
     * 数据备案查询条件
     */
    private String userName; // 学员姓名
    private String nameRemark;//姓名备注
    private String telephone; // 联系电话
    private String qq; // qq号码
    private String schoolArea;// 校区
    private String consultationPerson;// 咨询师
    private String consultationProcess;// 咨询进度
    private String nowStatus;// 学员状态
    private String infoSource;// 信息来源
    private String marketType;// 市场分类
    private String consultationType;// 咨询分类
    private String marketer;// 市场专员
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date keeponStartTime;// 备案开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date keeponEndTime;// 备案结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consultationStartTime;// 咨询时间开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consultationEndTime;// 咨询时间结束

    /**
     * 市场备案查询
     */
    private String keeponSearch; // 学员姓名、QQ、电话、地域

    /**
     * 回返查询
     */
    private String retuSearch;//姓名  电话  地址  qq 咨询师

    /**
     * 待上门查询
     */
    private String visitSearch;//姓名  电话  地址  qq 咨询师

    public String getNameRemark() {
        return nameRemark;
    }

    public void setNameRemark(String nameRemark) {
        this.nameRemark = nameRemark;
    }

    public String getRetuSearch() {
        return retuSearch;
    }

    public void setRetuSearch(String retuSearch) {
        this.retuSearch = retuSearch;
    }

    public String getVisitSearch() {
        return visitSearch;
    }

    public void setVisitSearch(String visitSearch) {
        this.visitSearch = visitSearch;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Date getDeptEndTime() {
        return deptEndTime;
    }

    public void setDeptEndTime(Date deptEndTime) {
        this.deptEndTime = deptEndTime;
    }

/*	public Date getUserStartTime() {
		return userStartTime;
	}

	public void setUserStartTime(Date userStartTime) {
		this.userStartTime = userStartTime;
	}

	public Date getUserEndTime() {
		return userEndTime;
	}

	public void setUserEndTime(Date userEndTime) {
		this.userEndTime = userEndTime;
	}*/

    public String getUserSearch() {
        return userSearch;
    }

    public void setUserSearch(String userSearch) {
        this.userSearch = userSearch;
    }

    public Date getResourceStartTime() {
        return resourceStartTime;
    }

    public void setResourceStartTime(Date resourceStartTime) {
        this.resourceStartTime = resourceStartTime;
    }

    public Date getResourceEndTime() {
        return resourceEndTime;
    }

    public void setResourceEndTime(Date resourceEndTime) {
        this.resourceEndTime = resourceEndTime;
    }

    public String getResourceSearch() {
        return resourceSearch;
    }

    public void setResourceSearch(String resourceSearch) {
        this.resourceSearch = resourceSearch;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getDeptStartTime() {
        return deptStartTime;
    }

    public void setDeptStartTime(Date deptStartTime) {
        this.deptStartTime = deptStartTime;
    }

    public Date getdeptEndTime() {
        return deptEndTime;
    }

    public void setdeptEndTime(Date deptEndTime) {
        this.deptEndTime = deptEndTime;
    }

    public String getDeptSearch() {
        return deptSearch;
    }

    public void setDeptSearch(String deptSearch) {
        this.deptSearch = deptSearch;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(String schoolArea) {
        this.schoolArea = schoolArea;
    }

    public String getConsultationPerson() {
        return consultationPerson;
    }

    public void setConsultationPerson(String consultationPerson) {
        this.consultationPerson = consultationPerson;
    }

    public String getConsultationProcess() {
        return consultationProcess;
    }

    public void setConsultationProcess(String consultationProcess) {
        this.consultationProcess = consultationProcess;
    }

    public String getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(String nowStatus) {
        this.nowStatus = nowStatus;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public String getMarketer() {
        return marketer;
    }

    public void setMarketer(String marketer) {
        this.marketer = marketer;
    }

    public Date getKeeponStartTime() {
        return keeponStartTime;
    }

    public void setKeeponStartTime(Date keeponStartTime) {
        this.keeponStartTime = keeponStartTime;
    }

    public Date getKeeponEndTime() {
        return keeponEndTime;
    }

    public void setKeeponEndTime(Date keeponEndTime) {
        this.keeponEndTime = keeponEndTime;
    }

    public Date getConsultationStartTime() {
        return consultationStartTime;
    }

    public void setConsultationStartTime(Date consultationStartTime) {
        this.consultationStartTime = consultationStartTime;
    }

    public Date getConsultationEndTime() {
        return consultationEndTime;
    }

    public void setConsultationEndTime(Date consultationEndTime) {
        this.consultationEndTime = consultationEndTime;
    }

    public String getKeeponSearch() {
        return keeponSearch;
    }

    public void setKeeponSearch(String keeponSearch) {
        this.keeponSearch = keeponSearch;
    }

    @Override
    public String toString() {
        return "Condition [userSearch="
                + userSearch + ", resourceStartTime=" + resourceStartTime + ", resourceEndTime=" + resourceEndTime
                + ", resourceSearch=" + resourceSearch + ", roleName=" + roleName + ", baseName=" + baseName
                + ", deptStartTime=" + deptStartTime + ", deptEndTime=" + deptEndTime + ", deptSearch=" + deptSearch
                + ", userName=" + userName + ", telephone=" + telephone + ", qq=" + qq + ", schoolArea=" + schoolArea
                + ", consultationPerson=" + consultationPerson + ", consultationProcess=" + consultationProcess
                + ", nowStatus=" + nowStatus + ", infoSource=" + infoSource + ", marketType=" + marketType
                + ", consultationType=" + consultationType + ", marketer=" + marketer + ", keeponStartTime="
                + keeponStartTime + ", keeponEndTime=" + keeponEndTime + ", consultationStartTime="
                + consultationStartTime + ", consultationEndTime=" + consultationEndTime + ", keeponSearch="
                + keeponSearch + "]";
    }

}
