package com.newer.service.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.sys.BaseMapper;
import com.newer.pojo.sys.Base;
import com.newer.pojo.sys.examples.BaseExample;
import com.newer.pojo.sys.examples.BaseExample.Criteria;
import com.newer.service.sys.BaseService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.IsNotNullUtil;

@Service
public class BaseServiceImpl implements BaseService {

    //注入dao层
    @Autowired
    private BaseMapper baseMapper;

    /**
     * 条件分页查询基础信息
     */
    @Override
    public BootstrapDataTable listAll(BootstrapDataTable dataTable, Condition condition) {
        PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        BaseExample example = new BaseExample();
        // 去充
        example.setDistinct(true);
        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            example.setOrderByClause(dataTable.getSort() + " " + dataTable.getOrder());
        }
        Criteria criteria = example.createCriteria();
        criteria.andDeletestatusEqualTo("0");
        // 条件查询
        if (IsNotNullUtil.isNotNull(condition.getBaseName())) {
            criteria.andNameLike("%" + condition.getBaseName() + "%");
        }
        List<Base> list = baseMapper.selectByExample(example);
        PageInfo<Base> info = new PageInfo<Base>(list);
        // 实例一个数据表对象
        BootstrapDataTable data = new BootstrapDataTable();
        // 设值
        data.setTotal((int) info.getTotal());
        data.setRows(info.getList());
        return data;
    }

    /**
     * 批量删除
     */
    @Override
    public boolean batchDelete(String strIds) {
        String[] split = strIds.split(",");
        List<Integer> ids = new ArrayList<Integer>();
        for (String id : split) {
            ids.add(Integer.parseInt(id));
        }
        return baseMapper.batchDelete(ids);
    }

    /**
     * 根据id查出基础信息
     */
    @Override
    public Base selectByPrimaryKey(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改基础信息
     */
    @Override
    public boolean updateByPrimaryKeySelective(Base record) {
        try {
            baseMapper.updateByPrimaryKeySelective(record);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加一条基础信息
     */
    @Override
    public boolean insertSelective(Base record) {
        //设置默认值
        record.setDeletestatus("0");
        record.setPid(0);
        record.setCreatetime(new Date());
        try {
            baseMapper.insertSelective(record);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除一条基础信息
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        try {
            baseMapper.deleteByPrimaryKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Base> selectByName(String name) {
        return baseMapper.selectByName(name);
    }

    @Override
    public Set<String> selectEducation(String name) {
        return baseMapper.selectEducation(name);
    }

}
