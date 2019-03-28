package com.newer.dao.student;

import java.util.List;

import com.newer.dto.MarkDto;
import com.newer.pojo.student.Mark;
import com.newer.pojo.student.MarkExample;

public interface MarkMapper {
    int deleteByPrimaryKey(Integer markId);

    int insert(Mark record);

    int insertSelective(Mark record);

    List<Mark> selectByExample(MarkExample example);

    Mark selectByPrimaryKey(Integer markId);

    int updateByPrimaryKeySelective(Mark record);

    int updateByPrimaryKey(Mark record);

    //增加成绩的组合查询
    List<Mark> selectSubjectsByDto(MarkDto markDto);
}