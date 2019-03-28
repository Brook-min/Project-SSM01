package com.newer.service.sys.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.dao.sys.ConsultationMapper;
import com.newer.dao.sys.KeeponMapper;
import com.newer.pojo.sys.Consultation;
import com.newer.pojo.sys.Keepon;
import com.newer.service.sys.ConsultationService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.MsgUtil;

/**
 * 咨询信息业务逻辑层
 *
 * @author LiuKang
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Autowired
    private KeeponMapper keeponMapper;

    /**
     * 添加咨询信息
     */
    @Override
    public MsgUtil addConsultation(Consultation consultation, Keepon keepon) {
        try {
            //咨询时间
            Date date = new Date();
            //咨询时间为当前时间
            consultation.setConsultationtime(date);
            //添加咨询信息
            consultationMapper.insertSelective(consultation);
            //设置预计上门时间
            keepon.setVisitdate(keepon.getVisitdate());
            //设置提醒时间(上门时间前三天)
//		DateTime dateTime = new DateTime(keepon.getVisiteddate());
//		keepon.setRemindtime(dateTime.minusDays(3).toDate());
            keepon.setRemindtime(keepon.getRemindtime());
            //该备案的最新咨询时间
            keepon.setConsultationtime(date);
            //设置最新进度
            keepon.setConsultationprocess(consultation.getProcess());
            keepon.setId(consultation.getKeeponid());
            //修改备案信息
            keeponMapper.updateByPrimaryKeySelective(keepon);
            return MsgUtil.result(true, "操作成功!");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙");
        }
    }

    /**
     * 根据编号链表查询
     */
    @Override
    public BootstrapDataTable selectConsultationWithKeeponById(Integer id, BootstrapDataTable bootstrapDataTable) {
        List<Consultation> consultations = keeponMapper.selectKeeponWithConsultationsById(id).getConsultations();
        bootstrapDataTable.setRows(consultations);
        bootstrapDataTable.setTotal(consultations.size());
        return bootstrapDataTable;
    }

}
