package com.newer.service.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.User;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.MsgUtil;

public interface KeeponService {

    /**
     * 添加备案信息
     *
     * @param keepon
     * @return
     */
    MsgUtil addKeepon(Keepon keepon);

    /**
     * 查询资源信息中的备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    BootstrapDataTable selectConsultationKeepon(BootstrapDataTable bootstrapDataTable, Condition condition,
                                                HttpSession session, String page);

    /**
     * 查询所有指派咨询师
     *
     * @return
     */
    public List<User> selectConsultant();

    /**
     * 根据id查询学员信息，查看是否有咨询师
     *
     * @param id
     * @return
     */
    public Keepon selectKeeponById(Integer id);

    /**
     * 只能查询当前登录人的备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    public BootstrapDataTable selectIsKeepon(BootstrapDataTable bootstrapDataTable, Condition condition);

    /**
     * 只能查询当前用户的备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    public BootstrapDataTable selectKeeponByPerson(BootstrapDataTable bootstrapDataTable, Condition condition);

    /**
     * 修改指定人
     *
     * @param keepon
     * @return
     */
    public int updateKeepon(Keepon keepon);

    /**
     * 前台管理条件查询备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @param session
     * @return
     */
    BootstrapDataTable selectAll(BootstrapDataTable bootstrapDataTable, Condition condition);

    /**
     * 导入excel
     *
     * @param fileName
     * @param session
     * @return
     */
    String ReadExcel(CommonsMultipartFile fileName, HttpSession session);

    Keepon selectKeeponWithConsultationById(Integer id);

    /**
     * 转上门
     *
     * @param keepon
     * @return
     */
    boolean updateKeeponWithConsultation(Keepon keepon);

    /**
     * 转进班
     *
     * @param keepon
     * @return
     */
    boolean updatetransferToClass(Keepon keepon);

    /**
     * 回访记录
     *
     * @param dataTable
     * @param condition
     * @param session
     * @return
     */
    BootstrapDataTable keepReturn(BootstrapDataTable dataTable, Condition condition, HttpServletRequest request);

    /**
     * 待上门
     *
     * @param dataTable
     * @param condition
     * @return
     */
    BootstrapDataTable keepVisit(BootstrapDataTable dataTable, Condition condition, HttpServletRequest request);

    /**
     * 查询所有市场专员
     *
     * @return
     */
    List<User> selectMarker();

    /**
     * 查询电话号码
     *
     * @param telephone
     * @return
     */
    List<Keepon> selectByTelephone(String telephone);

    /**
     * 查询qq
     *
     * @param qq
     * @return
     */
    List<Keepon> selectByQq(String qq);

    /**
     * 未上门
     *
     * @param id
     * @return
     */
    boolean notVis(Integer id);

    /**
     * 修改备案信息
     *
     * @param record
     * @return
     */
    boolean updateByPrimaryKeySelective(Keepon record);

}
