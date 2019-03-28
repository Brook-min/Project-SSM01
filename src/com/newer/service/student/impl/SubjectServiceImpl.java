package com.newer.service.student.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jhlabs.image.CircleFilter;
import com.newer.dao.student.SubjectMapper;
import com.newer.pojo.student.Subject;
import com.newer.pojo.student.SubjectExample;
import com.newer.pojo.student.SubjectExample.Criteria;
import com.newer.service.student.SubjectService;
import com.newer.util.sys.BootstrapDataTable;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public BootstrapDataTable listAll(BootstrapDataTable dataTable, String subName) {
        // 给PageHelper设参数
        PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());

        // 实例化Example
        SubjectExample example = new SubjectExample();
        Criteria criteria = example.createCriteria();
        if (subName != null) {
            criteria.andSubNameLike("%" + subName + "%");
        }

        //排序
        if (dataTable.getSort() != null && !"".equals(dataTable.getSort()) && dataTable.getOrder() != null) {
            if ("subId".equals(dataTable.getSort())) {
                example.setOrderByClause("sub_id " + dataTable.getOrder());
            }

            if ("subName".equals(dataTable.getSort())) {
                example.setOrderByClause("sub_name " + dataTable.getOrder());
            }
        }

        // 调用mpper层方法查询所有角色
        List<Subject> list = subjectMapper.selectByExample(example);
        // 实例一个PageInfo对象 ，并设置参数list
        PageInfo<Subject> info = new PageInfo<Subject>(list);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();
        // 设值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());
        // 返回对象
        return bootDataTable;
    }

    @Override
    public void save(Subject subject) {
        // TODO Auto-generated method stub
        this.subjectMapper.insert(subject);
    }

    @Override
    public Map<String, Boolean> checkSubName(String subName) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        // 根据科目名查询
        SubjectExample example = new SubjectExample();
        Criteria criteria = example.createCriteria();
        criteria.andSubNameEqualTo(subName);
        List list = subjectMapper.selectByExample(example);
        // 设置结果值
        boolean result = true;
        // 判断集合是否为空
        if (list != null && list.size() > 0) {
            result = false;
        }
        // 设置参数
        map.put("valid", result);
        return map;
    }

}
