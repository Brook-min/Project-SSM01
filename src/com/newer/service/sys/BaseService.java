package com.newer.service.sys;


import java.util.List;
import java.util.Set;

import com.newer.pojo.sys.Base;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;

public interface BaseService {

    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, Condition condition);

    boolean batchDelete(String ids);

    Base selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Base record);

    boolean insertSelective(Base record);

    boolean deleteByPrimaryKey(Integer id);

    List<Base> selectByName(String name);

    //查询学历信息
    Set<String> selectEducation(String name);

}
