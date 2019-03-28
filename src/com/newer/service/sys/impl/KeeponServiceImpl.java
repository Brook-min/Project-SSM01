package com.newer.service.sys.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.sys.BaseMapper;
import com.newer.dao.sys.ConsultationMapper;
import com.newer.dao.sys.KeeponMapper;
import com.newer.pojo.sys.Base;
import com.newer.pojo.sys.Consultation;
import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.ConsultationExample;
import com.newer.pojo.sys.examples.KeeponExample;
import com.newer.pojo.sys.examples.KeeponExample.Criteria;
import com.newer.service.sys.KeeponService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.DataUtil;
import com.newer.util.sys.IsNotNullUtil;
import com.newer.util.sys.MsgUtil;
import com.newer.util.sys.ReadExcel;
import com.newer.util.sys.UserSession;

/**
 * 备案信息逻辑管理层
 *
 * @author 奉小军
 */
@Service
public class KeeponServiceImpl implements KeeponService {
    @Autowired
    private KeeponMapper keeponMapper;
    @Autowired
    private ConsultationMapper consultationMapper;
    @Autowired
    private BaseMapper baseMapper;

    /**
     * 添加备案信息
     */
    @Override
    public MsgUtil addKeepon(Keepon keepon) {
        try {
            // 设置备案时间为当前系统时间
            keepon.setKeepontime(new Date());
            // 设置目前状态为未上门
            keepon.setNowstatus("未上门");
            keeponMapper.insertSelective(keepon);
            return MsgUtil.result(true, "操作成功!");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙!");
        }
    }

    /**
     * 咨询管理和市场管理下的备案信息查询 查询资源信息中的备案信息
     */
    @Override
    public BootstrapDataTable selectConsultationKeepon(BootstrapDataTable dataTable, Condition condition,
                                                       HttpSession session, String page) {
        UserSession userSession = (UserSession) session.getAttribute("userSession");
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(dataTable.getOffset()) && IsNotNullUtil.isNotNull(dataTable.getLimit())) {
            PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        }
        // 实例化keepon条件对象
        KeeponExample example = new KeeponExample();
        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            example.setOrderByClause(dataTable.getSort() + "  " + dataTable.getOrder());
        }
        // 实例筛选对象
        Criteria criteria = example.createCriteria();
        // 判断用户角色是否为咨询师
        Set<String> roleCodes = userSession.getRoleCodes();
        /**
         * 定义变量区分是否是2.咨询师 3.市场专员，4.网络主管 5.市场主管
         */
        int flag = 1;
        for (String roleCode : roleCodes) {
            /**
             * 咨询管理下的备案信息查询页面
             */
            if ("咨询页面".equals(page)) {
                // 定义变量判断是否为咨询师
                if ("counselor".equalsIgnoreCase(roleCode) && !"Consulting".equalsIgnoreCase(roleCode)) {
                    criteria.andRolecodeEqualTo("counselor");
                    criteria.andUidEqualTo(userSession.getId());
                    flag = 2;
                }
            }
            /**
             * 市场管理下的备案信息查询页面
             */
            if ("市场页面".equals(page)) {
                // 判断是否为市场人员
                if ("marketer".equalsIgnoreCase(roleCode)) {
                    criteria.andRolecodeEqualTo("marketer");
                    criteria.andUidEqualTo(userSession.getId());
                    flag = 3;
                }
                // 判断是否为网络主管
                if ("Network Manager".equalsIgnoreCase(roleCode)) {
                    criteria.andInfosourceEqualTo("网站");
                    // criteria.andRolecodeEqualTo("Network Manager");
                    // criteria.andUidEqualTo(userSession.getId());
                    flag = 4;// 网络主管
                }

                // 判断是否为市场主管
                if ("Marketing".equalsIgnoreCase(roleCode)) {
                    example.setKepponid(userSession.getId());// 设置备案人id条件
                    flag = 5;// 市场主管
                }

                // 判断是否为网络咨询师
                if ("Network Consultants".equalsIgnoreCase(roleCode)) {
                    criteria.andRolecodeEqualTo("Network Consultants");
                    // example.setKepponid(userSession.getId());// 设置备案人id条件
                    flag = 6;// 网络咨询师
                }
            }
        }
        // 学员姓名模糊查询
        if (IsNotNullUtil.isNotNull(condition.getUserName())) {
            criteria.andStudentnameLike("%" + condition.getUserName() + "%");
        }
        // 姓名备注模糊查询
        if (IsNotNullUtil.isNotNull(condition.getNameRemark())) {
            criteria.andNameremarkLike("%" + condition.getNameRemark() + "%");
        }
        // 学员电话
        if (IsNotNullUtil.isNotNull(condition.getTelephone())) {
            criteria.andTelephoneEqualTo2(condition.getTelephone());
        }
        // qq
        if (IsNotNullUtil.isNotNull(condition.getQq())) {
            criteria.andQqEqualTo(condition.getQq());
        }
        // 校区
        if (IsNotNullUtil.isNotNull(condition.getSchoolArea())) {
            criteria.andSchoolareaEqualTo(condition.getSchoolArea());
        }
        // 咨询师
        if (IsNotNullUtil.isNotNull(condition.getConsultationPerson())) {
            criteria.andConsultationpersonEqualTo(condition.getConsultationPerson());
        }
        // 咨询进度
        if (IsNotNullUtil.isNotNull(condition.getConsultationProcess())) {
            criteria.andConsultationprocessEqualTo(condition.getConsultationProcess());
        }
        // 学员状态
        if (IsNotNullUtil.isNotNull(condition.getNowStatus())) {
            criteria.andNowstatusEqualTo(condition.getNowStatus());
        }
        // 信息来源
        if (IsNotNullUtil.isNotNull(condition.getInfoSource())) {
            criteria.andInfosourceEqualTo(condition.getInfoSource());
        }
        // 市场分类
        if (IsNotNullUtil.isNotNull(condition.getMarketType())) {
            criteria.andMarkettypeEqualTo(condition.getMarketType());
        }
        // 咨询分类
        if (IsNotNullUtil.isNotNull(condition.getConsultationType())) {
            criteria.andConsultationtypeEqualTo(condition.getConsultationType());
        }
        // 市场专员
        if (IsNotNullUtil.isNotNull(condition.getMarketer())) {
            criteria.andMarketerEqualTo(condition.getMarketer());
        }
        // 判断备案时间
        /*
         * if (condition.getKeeponStartTime() != null &&
         * condition.getKeeponEndTime() != null) {
         * criteria.andKeepontimeBetween(condition.getKeeponStartTime(),
         * condition.getKeeponEndTime()); // 查找消息，还需要创建个筛选对象 }
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (condition.getKeeponStartTime() != null && condition.getKeeponEndTime() != null) {
            criteria.andKeepontimeBetween(sdf.format(condition.getKeeponStartTime()),
                    sdf.format(condition.getKeeponEndTime()));
            // 查找消息，还需要创建个筛选对象
        }
        if (condition.getKeeponStartTime() != null && condition.getKeeponEndTime() == null) {
            criteria.andKeepontimeGreaterThanOrEqualTo(condition.getKeeponStartTime());
        }
        if (condition.getKeeponStartTime() == null && condition.getKeeponEndTime() != null) {
            criteria.andKeepontimeLessThanOrEqualTo(condition.getKeeponEndTime());
        }

        // 判断咨询时间
        /*
         * if (condition.getConsultationStartTime() != null &&
         * condition.getConsultationEndTime() != null) {
         * criteria.andConsultationtimeBetween(condition.
         * getConsultationStartTime(), condition.getConsultationEndTime()); }
         */
        if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() != null) {
            criteria.andConsultationtimeBetween(sdf.format(condition.getConsultationStartTime()),
                    sdf.format(condition.getConsultationEndTime()));
        }
        if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() == null) {
            criteria.andConsultationtimeGreaterThanOrEqualTo(condition.getConsultationStartTime());
        }
        if (condition.getConsultationStartTime() == null && condition.getConsultationEndTime() != null) {
            criteria.andConsultationtimeLessThanOrEqualTo(condition.getConsultationEndTime());
        }
        List<Keepon> selectByExample = null;
        // 查询备案列表
        if (flag == 1) {
            selectByExample = keeponMapper.selectByExample(example);
        } else if (flag == 2) {
            selectByExample = keeponMapper.selectKeeponByRoleCode(example);
        } else if (flag == 3) {
            selectByExample = keeponMapper.selectKeeponByMarketer(example);
        } else if (flag == 4) {
            selectByExample = keeponMapper.selectKeeponByNet(example);
        } else if (flag == 5) {
            selectByExample = keeponMapper.selectKeeponByMarketing(example);
        } else if (flag == 6) {
            selectByExample = keeponMapper.selectKeeponByNet(example);
        }

        // 实例一个PageInfo对象 ，并设置参数keeponlist
        PageInfo<Keepon> info = new PageInfo<Keepon>(selectByExample);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();

        // 设置值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());
        return bootDataTable;
    }

    /**
     * 指派咨询师
     */
    @Override
    public List<User> selectConsultant() {
        return keeponMapper.selectConsultant();
    }

    /**
     * 根据id查询备案信息
     */
    @Override
    public Keepon selectKeeponById(Integer id) {
        return keeponMapper.selectByPrimaryKey(id);
    }

    /**
     * 是否备案查询
     */
    @Override
    public BootstrapDataTable selectIsKeepon(BootstrapDataTable bootstrapDataTable, Condition condition) {
        BootstrapDataTable dataTable = new BootstrapDataTable();
        // 定义条件变量
        String search = condition.getKeeponSearch();
        if (IsNotNullUtil.isNotNull(search)) {
            // 实例化keppon条件对象
            KeeponExample example = new KeeponExample();
            // 把备案时间设为倒叙
            example.setOrderByClause("keepontime desc");
            // 实例学员姓名筛选对象
            Criteria c1 = example.createCriteria();
            c1.andStudentnameEqualTo(search);
            // 实例QQ筛选对象
            Criteria c2 = example.createCriteria();
            c2.andQqEqualTo(search);

            // 实例联系电话筛选对象
            Criteria c3 = example.createCriteria();
            c3.andTelephoneEqualTo(search);

            // 实例地域筛选对象
            Criteria c4 = example.createCriteria();
            c4.andAreaLike("%" + search + "%");

            // 实例姓名备注筛选对象
            Criteria c5 = example.createCriteria();
            c5.andNameremarkEqualTo(search);

            example.or(c1);
            example.or(c2);
            example.or(c3);
            example.or(c4);
            example.or(c5);

            List<Keepon> list = keeponMapper.selectByExample(example);
            dataTable.setRows(list);
            dataTable.setTotal(list.size());
        }
        return dataTable;
    }

    /**
     * 备案查询
     */
    @Override
    public BootstrapDataTable selectKeeponByPerson(BootstrapDataTable dataTable, Condition condition) {
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(dataTable.getOffset()) && IsNotNullUtil.isNotNull(dataTable.getLimit())) {
            PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        }
        // 实例化keepon条件对象
        KeeponExample example = new KeeponExample();
        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            example.setOrderByClause(dataTable.getSort() + "  " + dataTable.getOrder());
        }

        if (IsNotNullUtil.isNotNull(condition)) {
            // 实例筛选对象
            Criteria criteria = example.createCriteria();

            // 学员姓名模糊查询
            if (IsNotNullUtil.isNotNull(condition.getUserName())) {
                criteria.andStudentnameLike("%" + condition.getUserName() + "%");
            }

            // 判断咨询时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            /*
             * if (condition.getConsultationStartTime() != null &&
             * condition.getConsultationEndTime() != null) {
             * criteria.andConsultationtimeBetween(condition.
             * getConsultationStartTime(), condition.getConsultationEndTime());
             * }
             */

            if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() != null) {
                criteria.andConsultationtimeBetween(sdf.format(condition.getConsultationStartTime()),
                        sdf.format(condition.getConsultationEndTime()));
            }
            if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() == null) {
                criteria.andConsultationtimeGreaterThanOrEqualTo(condition.getConsultationStartTime());
            }
            if (condition.getConsultationStartTime() == null && condition.getConsultationEndTime() != null) {
                criteria.andConsultationtimeLessThanOrEqualTo(condition.getConsultationEndTime());
            }

        }
        // 调用mapper层方法
        List<Keepon> list = keeponMapper.selectByExample(example);
        // 实例一个PageInfo对象 ，并设置参数keeponlist
        PageInfo<Keepon> info = new PageInfo<Keepon>(list);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();

        // 设置值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());
        return bootDataTable;
    }

    /**
     * 更新指定人
     */
    @Override
    public int updateKeepon(Keepon keepon) {
        return keeponMapper.updateByPrimaryKeySelective(keepon);
    }

    @Override
    public BootstrapDataTable selectAll(BootstrapDataTable dataTable, Condition condition) {
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(dataTable.getOffset()) && IsNotNullUtil.isNotNull(dataTable.getLimit())) {
            PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        }
        // 实例化keepon条件对象
        KeeponExample example = new KeeponExample();

        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            example.setOrderByClause(dataTable.getSort() + "  " + dataTable.getOrder());
        }
        // 实例筛选对象
        Criteria criteria = example.createCriteria();

        // 学员姓名模糊查询
        if (IsNotNullUtil.isNotNull(condition.getUserName())) {
            criteria.andStudentnameLike("%" + condition.getUserName() + "%");
        }
        // 学员姓名模糊查询
        if (IsNotNullUtil.isNotNull(condition.getNameRemark())) {
            criteria.andNameremarkLike("%" + condition.getNameRemark() + "%");
        }
        // 学员电话
        if (IsNotNullUtil.isNotNull(condition.getTelephone())) {
            criteria.andTelephoneEqualTo(condition.getTelephone());
        }
        // qq
        if (IsNotNullUtil.isNotNull(condition.getQq())) {
            criteria.andQqEqualTo(condition.getQq());
        }
        // 校区
        if (IsNotNullUtil.isNotNull(condition.getSchoolArea())) {
            criteria.andSchoolareaEqualTo(condition.getSchoolArea());
        }
        // 咨询师
        if (IsNotNullUtil.isNotNull(condition.getConsultationPerson())) {
            criteria.andConsultationpersonEqualTo(condition.getConsultationPerson());
        }
        // 咨询进度
        if (IsNotNullUtil.isNotNull(condition.getConsultationProcess())) {
            criteria.andConsultationprocessEqualTo(condition.getConsultationProcess());
        }
        // 学员状态
        if (IsNotNullUtil.isNotNull(condition.getNowStatus())) {
            criteria.andNowstatusEqualTo(condition.getNowStatus());
        }
        // 信息来源
        if (IsNotNullUtil.isNotNull(condition.getInfoSource())) {
            criteria.andInfosourceEqualTo(condition.getInfoSource());
        }
        // 市场分类
        if (IsNotNullUtil.isNotNull(condition.getMarketType())) {
            criteria.andMarkettypeEqualTo(condition.getMarketType());
        }
        // 咨询分类
        if (IsNotNullUtil.isNotNull(condition.getConsultationType())) {
            criteria.andConsultationtypeEqualTo(condition.getConsultationType());
        }
        // 市场专员
        if (IsNotNullUtil.isNotNull(condition.getMarketer())) {
            criteria.andMarketerEqualTo(condition.getMarketer());
        }
        // 判断备案时间
        /*
         * if (condition.getKeeponStartTime() != null &&
         * condition.getKeeponEndTime() != null) {
         * criteria.andKeepontimeBetween(condition.getKeeponStartTime(),
         * condition.getKeeponEndTime()); // 查找消息，还需要创建个筛选对象 }
         */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (condition.getKeeponStartTime() != null && condition.getKeeponEndTime() != null) {
            criteria.andKeepontimeBetween(sdf.format(condition.getKeeponStartTime()),
                    sdf.format(condition.getKeeponEndTime()));
            // 查找消息，还需要创建个筛选对象
        }
        if (condition.getKeeponStartTime() != null && condition.getKeeponEndTime() == null) {
            criteria.andKeepontimeGreaterThanOrEqualTo(condition.getKeeponStartTime());
        }
        if (condition.getKeeponStartTime() == null && condition.getKeeponEndTime() != null) {
            criteria.andKeepontimeLessThanOrEqualTo(condition.getKeeponEndTime());
        }

        // 判断咨询时间
        /*
         * if (condition.getConsultationStartTime() != null &&
         * condition.getConsultationEndTime() != null) {
         * criteria.andConsultationtimeBetween(condition.
         * getConsultationStartTime(), condition.getConsultationEndTime()); }
         */
        if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() != null) {
            criteria.andConsultationtimeBetween(sdf.format(condition.getConsultationStartTime()),
                    sdf.format(condition.getConsultationEndTime()));
        }

        if (condition.getConsultationStartTime() != null && condition.getConsultationEndTime() == null) {
            criteria.andConsultationtimeGreaterThanOrEqualTo(condition.getConsultationStartTime());
        }
        if (condition.getConsultationStartTime() == null && condition.getConsultationEndTime() != null) {
            criteria.andConsultationtimeLessThanOrEqualTo(condition.getConsultationEndTime());
        }
        List<Keepon> list = keeponMapper.selectByExample(example);

        // 实例一个PageInfo对象 ，并设置参数keeponlist
        PageInfo<Keepon> info = new PageInfo<Keepon>(list);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();

        // 设置值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());
        return bootDataTable;
    }

    /**
     * 导入数据： 规则：1、学员姓名可以重复但是不能为空 2、性别不能为空 3、年龄不能为空 4、联系电话或者QQ两者不能都为空 5、信息来源不能为空
     */
    @Override
    public String ReadExcel(CommonsMultipartFile fileName, HttpSession session) {
        // 创建处理EXCEL
        ReadExcel readExcel = new ReadExcel();
        // 解析excel，获取客户信息集合。
        List<Keepon> keeponList = readExcel.getExcelInfo(fileName, session);
        for (Keepon keepon : keeponList) {
            if (IsNotNullUtil.isNull(keepon.getStudentname())) {
                return "错误:学员姓名不能为空";
            } /*
             * else { // 防止学员姓名不能重复 List<Keepon> stuName =
             * keeponMapper.selectByName(keepon.getStudentname());
             * System.out.println("学员姓名" + stuName.size()); if
             * (stuName.size() != 0) { return "错误:学员姓名<" +
             * keepon.getStudentname() + ">已经备案"; } }
             */
            if (IsNotNullUtil.isNull(keepon.getSex())) {
                return "错误:性别不能为空";
            }
            if (IsNotNullUtil.isNull(keepon.getAge())) {
                return "错误:年龄不能为空";
            }
            if (IsNotNullUtil.isNull(keepon.getTelephone()) && IsNotNullUtil.isNull(keepon.getQq())) {
                return "错误:联系电话和QQ不能都为空";
            } else {
                // 防止联系电话不能重复
                List<Keepon> telephone = keeponMapper.selectByTelephone(keepon.getTelephone());
                if (telephone.size() != 0) {
                    return "错误:联系电话<" + keepon.getTelephone() + ">已经备案";
                }
            }
            if (IsNotNullUtil.isNull(keepon.getInfosource())) {
                return "错误:信息来源不能为空";
            }
            if (IsNotNullUtil.isNotNull(keepon.getQq())) {
                // 防止qq不能重复
                List<Keepon> selectQq = keeponMapper.selectByQq(keepon.getQq());
                if (selectQq.size() != 0) {
                    return "错误:qq<" + keepon.getQq() + ">已经备案";
                }
            }
        }

        // 迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        boolean batchInsert = keeponMapper.BatchInsert(keeponList);
        if (batchInsert) {
            return "成功";
        }
        return "错误：导入失败，请仔细检查您的表格数据格式是否正确";
    }

    // 根据id查询备案信息连接查询咨询表
    @Override
    public Keepon selectKeeponWithConsultationById(Integer id) {
        return keeponMapper.selectKeeponWithConsultationById(id);
    }

    /**
     * 转上门
     */
    @Override
    public boolean updateKeeponWithConsultation(Keepon keepon) {
        try {
            // 设置咨询表对象数据
            Consultation consultation = keepon.getConsultation();
            if (IsNotNullUtil.isNotNull(keepon.getId())) {
                consultation.setKeeponid(keepon.getId());
            }
            if (IsNotNullUtil.isNotNull(keepon.getConsultationperson())) {
                consultation.setConsultationname(keepon.getConsultationperson());
            }
            // 设置目前状态为已上门
            keepon.setNowstatus("已上门");
            keeponMapper.updateByPrimaryKeySelective(keepon);
            ConsultationExample example = new ConsultationExample();
            com.newer.pojo.sys.examples.ConsultationExample.Criteria criteria = example.createCriteria();
            criteria.andKeeponidEqualTo(consultation.getKeeponid());
            consultationMapper.updateByPrimaryKeySelective(consultation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 转进班
     */
    @Override
    public boolean updatetransferToClass(Keepon keepon) {
        try {
            // 设置学员目前状态为已进班
            keepon.setNowstatus("已进班");
            keeponMapper.updateByPrimaryKeySelective(keepon);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 回访记录（首页）
     */
    @Override
    public BootstrapDataTable keepReturn(BootstrapDataTable bootstrapDataTable, Condition condition,
                                         HttpServletRequest request) {
        // 给PageHelper设参数（分页处理）
        if (IsNotNullUtil.isNotNull(bootstrapDataTable.getOffset())
                && IsNotNullUtil.isNotNull(bootstrapDataTable.getLimit())) {
            PageHelper.offsetPage(bootstrapDataTable.getOffset(), bootstrapDataTable.getLimit());
        }
        // 实例化条件对象
        KeeponExample example = new KeeponExample();

        example.setOrderByClause("keepontime asc");

        // 定义条件变量（文本框中获取的条件）
        String search = condition.getRetuSearch();
        HttpSession session = request.getSession();
        UserSession user = (UserSession) session.getAttribute("userSession");
        Set<String> roleCodes = user.getRoleCodes();
        for (String code : roleCodes) {
            if ("counselor".equals(code)) {
                // 咨询师只查询自己的
                ConditionByName(example, search, user);
            } else {
                // 查询所有（咨询主管，管理员）
                ConditionAll(example, search);
            }
        }

        List<Keepon> list = keeponMapper.selectByExample(example);

        // 实例一个PageInfo对象 ，并设置参数keeponlist
        PageInfo<Keepon> info = new PageInfo<Keepon>(list);

        // 实例一个数据表对象
        BootstrapDataTable dataTable = new BootstrapDataTable();

        // 设置值
        dataTable.setTotal((int) info.getTotal());
        dataTable.setRows(info.getList());
        return dataTable;

    }

    /**
     * 待上门
     */
    @Override
    public BootstrapDataTable keepVisit(BootstrapDataTable bootstrapDataTable, Condition condition,
                                        HttpServletRequest request) {
        // 从基础数据表中查询天数
        List<Base> selectByName = baseMapper.selectByName("上门提醒日期");
        int DIsday = 0;
        for (Base base : selectByName) {
            DIsday = Integer.parseInt(base.getValue());
        }
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(bootstrapDataTable.getOffset())
                && IsNotNullUtil.isNotNull(bootstrapDataTable.getLimit())) {
            PageHelper.offsetPage(bootstrapDataTable.getOffset(), bootstrapDataTable.getLimit());
        }
        // 实例化条件对象
        KeeponExample example = new KeeponExample();

        example.setOrderByClause("visitdate desc");
        // 定义条件变量
        String search = condition.getVisitSearch();

        HttpSession session = request.getSession();
        UserSession user = (UserSession) session.getAttribute("userSession");
        Set<String> roleCodes = user.getRoleCodes();
        for (String code : roleCodes) {
            if ("counselor".equals(code)) {
                // 咨询师只查询自己的
                VisConditionByName(DIsday, example, search, user);
            } else {
                // 查询所有
                VisConditionAll(DIsday, example, search);
            }
        }
        List<Keepon> list = keeponMapper.selectByExample(example);

        // 实例一个PageInfo对象 ，并设置参数keeponlist
        PageInfo<Keepon> info = new PageInfo<Keepon>(list);

        // 实例一个数据表对象
        BootstrapDataTable dataTable = new BootstrapDataTable();

        // 设置值
        dataTable.setTotal((int) info.getTotal());
        dataTable.setRows(info.getList());
        return dataTable;
    }

    /**
     * 查询所有市场专员
     */
    @Override
    public List<User> selectMarker() {
        return keeponMapper.selectMarker();
    }

    @Override
    public List<Keepon> selectByTelephone(String telephone) {
        return keeponMapper.selectByTelephone(telephone);
    }

    @Override
    public List<Keepon> selectByQq(String qq) {
        return keeponMapper.selectByQq(qq);
    }

    /**
     * 待上门只查询自己
     *
     * @param DIsday
     * @param example
     * @param search
     * @param user
     */
    public void VisConditionByName(int DIsday, KeeponExample example, String search, UserSession user) {
        // 实例学员姓名筛选对象
        Criteria c1 = example.createCriteria();
        c1.andStudentnameLike("%" + search + "%");
        // 小于当前日期的预计上门时间
        c1.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        // 上门时间为空
        c1.andVisiteddateIsNull();
        c1.andConsultationpersonEqualTo(user.getRealname());
        // 预计上门时间不为空
        c1.andVisitdateIsNotNull();
        // 已经进班在不显示
        c1.andShifttimeIsNull();
        // 跟踪进度: 放弃不显示
        c1.andConsultationprocessNotEqualTo("放弃");

        // 实例QQ筛选对象
        Criteria c2 = example.createCriteria();
        c2.andQqLike("%" + search + "%");
        c2.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c2.andVisiteddateIsNull();
        c2.andConsultationpersonEqualTo(user.getRealname());
        c2.andVisitdateIsNotNull();
        // 已经进班在不显示
        c2.andShifttimeIsNull();
        c2.andConsultationprocessNotEqualTo("放弃");

        // 实例联系电话筛选对象
        Criteria c3 = example.createCriteria();
        c3.andTelephoneLike("%" + search + "%");
        c3.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c3.andVisiteddateIsNull();
        c3.andConsultationpersonEqualTo(user.getRealname());
        c3.andVisitdateIsNotNull();
        // 已经进班在不显示
        c3.andShifttimeIsNull();
        c3.andConsultationprocessNotEqualTo("放弃");

        // 实例地址筛选对象
        Criteria c4 = example.createCriteria();
        c4.andAreaLike("%" + search + "%");
        c4.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c4.andVisiteddateIsNull();
        c4.andConsultationpersonEqualTo(user.getRealname());
        c4.andVisitdateIsNotNull();
        // 已经进班在不显示
        c4.andShifttimeIsNull();
        c4.andConsultationprocessNotEqualTo("放弃");

        // 实例咨询师筛选对象
        Criteria c5 = example.createCriteria();
        c5.andConsultationpersonLike("%" + search + "%");
        c5.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c5.andVisiteddateIsNull();
        c5.andConsultationpersonEqualTo(user.getRealname());
        c5.andVisitdateIsNotNull();
        // 已经进班在不显示
        c5.andShifttimeIsNull();
        c5.andConsultationprocessNotEqualTo("放弃");

        // 实例姓名备注筛选对象
        Criteria c6 = example.createCriteria();
        c6.andNameremarkLike("%" + search + "%");
        c6.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c6.andVisiteddateIsNull();
        c6.andConsultationpersonEqualTo(user.getRealname());
        c6.andVisitdateIsNotNull();
        // 已经进班在不显示
        c6.andShifttimeIsNull();
        c6.andConsultationprocessNotEqualTo("放弃");

        example.or(c1);
        example.or(c2);
        example.or(c3);
        example.or(c4);
        example.or(c5);
        example.or(c6);
    }

    /**
     * 待上门查询所有
     *
     * @param DIsday
     * @param example
     * @param search
     */
    public void VisConditionAll(int DIsday, KeeponExample example, String search) {
        // 实例学员姓名筛选对象
        Criteria c1 = example.createCriteria();
        c1.andStudentnameLike("%" + search + "%");
        // 预计上门时间小于等于当前日期
        c1.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        // 上门时间为空
        c1.andVisiteddateIsNull();
        // 预计上门时间不为空
        c1.andVisitdateIsNotNull();
        // 已经进班在不显示
        c1.andShifttimeIsNull();
        // 跟踪进度放弃在不显示
        c1.andConsultationprocessNotEqualTo("放弃");

        // 实例QQ筛选对象
        Criteria c2 = example.createCriteria();
        c2.andQqLike("%" + search + "%");
        c2.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c2.andVisiteddateIsNull();
        c2.andVisitdateIsNotNull();
        // 已经进班在不显示
        c2.andShifttimeIsNull();
        c2.andConsultationprocessNotEqualTo("放弃");

        // 实例联系电话筛选对象
        Criteria c3 = example.createCriteria();
        c3.andTelephoneLike("%" + search + "%");
        c3.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c3.andVisiteddateIsNull();
        c3.andVisitdateIsNotNull();
        // 已经进班在不显示
        c3.andShifttimeIsNull();
        c3.andConsultationprocessNotEqualTo("放弃");

        // 实例地址筛选对象
        Criteria c4 = example.createCriteria();
        c4.andAreaLike("%" + search + "%");
        c4.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c4.andVisiteddateIsNull();
        c4.andVisitdateIsNotNull();
        // 已经进班在不显示
        c4.andShifttimeIsNull();
        c4.andConsultationprocessNotEqualTo("放弃");

        // 实例咨询师筛选对象
        Criteria c5 = example.createCriteria();
        c5.andConsultationpersonLike("%" + search + "%");
        c5.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c5.andVisiteddateIsNull();
        c5.andVisitdateIsNotNull();
        // 已经进班在不显示
        c5.andShifttimeIsNull();
        c5.andConsultationprocessNotEqualTo("放弃");

        // 实例姓名备注筛选对象
        Criteria c6 = example.createCriteria();
        c6.andNameremarkLike("%" + search + "%");
        c6.andVisitdateLessThanOrEqualTo(DataUtil.getNextDay(new Date(), DIsday));
        c6.andVisiteddateIsNull();
        c6.andVisitdateIsNotNull();
        // 已经进班在不显示
        c6.andShifttimeIsNull();
        c6.andConsultationprocessNotEqualTo("放弃");
        example.or(c1);
        example.or(c2);
        example.or(c3);
        example.or(c4);
        example.or(c5);
        example.or(c6);
    }

    /**
     * 回返记录咨询师查询
     *
     * @param example
     * @param search
     */
    public void ConditionAll(KeeponExample example, String search) {
        // 实例学员姓名筛选对象
        Criteria c1 = example.createCriteria();
        // 学员姓名模糊查询
        c1.andStudentnameLike("%" + search + "%");
        // 提醒时间小于等于当前系统时间
        c1.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c1.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c1.andShifttimeIsNull();
        // 跟踪进度不为“放弃”的，放弃的学员不显示
        c1.andConsultationprocessNotEqualTo("放弃");

        // 实例QQ筛选对象
        Criteria c2 = example.createCriteria();
        c2.andQqLike("%" + search + "%");
        c2.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c2.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c2.andShifttimeIsNull();
        c2.andConsultationprocessNotEqualTo("放弃");

        // 实例联系电话筛选对象
        Criteria c3 = example.createCriteria();
        c3.andTelephoneLike("%" + search + "%");
        c3.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c3.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c3.andShifttimeIsNull();
        c3.andConsultationprocessNotEqualTo("放弃");

        // 实例地址筛选对象
        Criteria c4 = example.createCriteria();
        c4.andAreaLike("%" + search + "%");
        c4.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c4.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c4.andShifttimeIsNull();
        c4.andConsultationprocessNotEqualTo("放弃");

        // 实例咨询师筛选对象
        Criteria c5 = example.createCriteria();
        c5.andConsultationpersonLike("%" + search + "%");
        c5.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c5.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c5.andShifttimeIsNull();
        c5.andConsultationprocessNotEqualTo("放弃");

        // 实例姓名备注筛选对象
        Criteria c6 = example.createCriteria();
        c6.andNameremarkLike("%" + search + "%");
        c6.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c6.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c6.andShifttimeIsNull();
        c6.andConsultationprocessNotEqualTo("放弃");

        example.or(c1);
        example.or(c2);
        example.or(c3);
        example.or(c4);
        example.or(c5);
        example.or(c6);
    }

    /**
     * 咨询师只查询自己的回返记录
     *
     * @param example
     * @param search
     * @param user
     */
    public void ConditionByName(KeeponExample example, String search, UserSession user) {
        // 实例学员姓名筛选对象
        Criteria c1 = example.createCriteria();
        c1.andStudentnameLike("%" + search + "%");
        c1.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c1.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c1.andShifttimeIsNull();
        c1.andConsultationpersonEqualTo(user.getRealname());
        c1.andConsultationprocessNotEqualTo("放弃");

        // 实例QQ筛选对象
        Criteria c2 = example.createCriteria();
        c2.andQqLike("%" + search + "%");
        c2.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c2.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c2.andShifttimeIsNull();
        c2.andConsultationpersonEqualTo(user.getRealname());
        c2.andConsultationprocessNotEqualTo("放弃");

        // 实例联系电话筛选对象
        Criteria c3 = example.createCriteria();
        c3.andTelephoneLike("%" + search + "%");
        c3.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c3.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c3.andShifttimeIsNull();
        c3.andConsultationpersonEqualTo(user.getRealname());
        c3.andConsultationprocessNotEqualTo("放弃");

        // 实例地址筛选对象
        Criteria c4 = example.createCriteria();
        c4.andAreaLike("%" + search + "%");
        c4.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c4.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c4.andShifttimeIsNull();
        c4.andConsultationpersonEqualTo(user.getRealname());
        c4.andConsultationprocessNotEqualTo("放弃");

        // 实例咨询师筛选对象
        Criteria c5 = example.createCriteria();
        c5.andConsultationpersonLike("%" + search + "%");
        c5.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c5.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c5.andShifttimeIsNull();
        c5.andConsultationpersonEqualTo(user.getRealname());
        c5.andConsultationprocessNotEqualTo("放弃");

        // 实例姓名备注筛选对象
        Criteria c6 = example.createCriteria();
        c6.andNameremarkLike("%" + search + "%");
        c6.andRemindtimeLessThanOrEqualTo(new Date());
        // 最后跟踪时间小于提醒时间
        c6.andConsultationtimeLessThanOrEqualToRemindtime();
        // 判断是否已经进班，已进入班级不显示
        c6.andShifttimeIsNull();
        c6.andConsultationpersonEqualTo(user.getRealname());
        c6.andConsultationprocessNotEqualTo("放弃");

        example.or(c1);
        example.or(c2);
        example.or(c3);
        example.or(c4);
        example.or(c5);
        example.or(c6);
    }

    @Override
    public boolean notVis(Integer id) {
        Keepon keepon = keeponMapper.selectByPrimaryKey(id);
        keepon.setVisitdate(null);
        try {
            keeponMapper.updateByPrimaryKey(keepon);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateByPrimaryKeySelective(Keepon record) {
        try {
            keeponMapper.updateByPrimaryKeySelective(record);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
