package com.newer.service.sys;

import com.newer.pojo.sys.Consultation;
import com.newer.pojo.sys.Keepon;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.MsgUtil;

/**
 * 咨询信息业务逻辑接口
 *
 * @author LiuKang
 */
public interface ConsultationService {

    /**
     * 添加咨询信息
     *
     * @param consultation
     * @param keepon
     * @return
     */
    public MsgUtil addConsultation(Consultation consultation, Keepon keepon);

    /**
     * 根据编号一条备案信息查询多条咨询信息
     *
     * @param id
     * @return
     */
    public BootstrapDataTable selectConsultationWithKeeponById(Integer id, BootstrapDataTable bootstrapDataTable);

}
