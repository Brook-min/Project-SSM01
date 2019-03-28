package com.newer.dao.student;

import com.newer.pojo.student.Subject;
import com.newer.pojo.student.SubjectExample;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer subId);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(Integer subId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    int deleteByIds(Integer[] intArr);
}