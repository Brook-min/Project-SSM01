package com.newer.dao.sys;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Base;
import com.newer.pojo.sys.examples.BaseExample;

@Repository("baseMapper")
public interface BaseMapper {
    long countByExample(BaseExample example);

    int deleteByExample(BaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Base record);

    int insertSelective(Base record);

    List<Base> selectByExample(BaseExample example);

    Base selectByPrimaryKey(Integer id);

    List<Base> selectByName(String name);

    int updateByExampleSelective(@Param("record") Base record, @Param("example") BaseExample example);

    int updateByExample(@Param("record") Base record, @Param("example") BaseExample example);

    int updateByPrimaryKeySelective(Base record);

    int updateByPrimaryKey(Base record);

    boolean batchDelete(@Param("ids") List<Integer> ids);

    //查询学历信息
    Set<String> selectEducation(@Param("name") String name);

}