package com.newer.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Consultation;
import com.newer.pojo.sys.examples.ConsultationExample;

@Repository("consultationMapper")
public interface ConsultationMapper {
    long countByExample(ConsultationExample example);

    int deleteByExample(ConsultationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Consultation record);

    int insertSelective(Consultation record);

    List<Consultation> selectByExample(ConsultationExample example);

    Consultation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consultation record, @Param("example") ConsultationExample example);

    int updateByExample(@Param("record") Consultation record, @Param("example") ConsultationExample example);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKey(Consultation record);
}