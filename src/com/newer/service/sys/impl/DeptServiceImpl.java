package com.newer.service.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newer.dao.sys.DeptMapper;
import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.examples.DeptExample;
import com.newer.pojo.sys.examples.DeptExample.Criteria;
import com.newer.service.sys.DeptService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.IsNotNullUtil;

/**
 * 部门信息业务逻辑处理层
 *
 * @author 卿超
 */
@Service
public class DeptServiceImpl implements DeptService {

    // 注入Dao层
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 根据分页条件查询部门
     */
    @Override
    public BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable) {
        // 实例化条件查询对象
        // Condition condition = bootstrapDataTable.getCondition();
        // 实例化条件对象
        DeptExample deptExample = new DeptExample();
        // 判断条件是否为空
        if (IsNotNullUtil.isNotNull(deptExample)) {
            // 实例化字段级筛选对象1
            Criteria createCriteria = deptExample.createCriteria();
            // 只显示部门未删除的
            createCriteria.andDeletestatusEqualTo(0);
            /*
             * // 实例化字段级筛选对象2 DeptExample.Criteria createCriteria2 =
             * deptExample.createCriteria(); // 判断是否为空 if
             * (IsNotNullUtil.isNotNull(condition.getDeptSearch())) {
             * createCriteria.andDeptnameLike("%" + condition.getDeptSearch() + "%");
             * createCriteria2.andAddressLike("%" + condition.getDeptSearch() + "%"); } //
             * 如果开始时间有 结束时间没有 if (IsNotNullUtil.isNotNull(condition.getDeptStartTime()) &&
             * IsNotNullUtil.isNotNullWithOr(condition.getdeptEndTime())) {
             * createCriteria.andCreatetimeGreaterThan(condition.getDeptStartTime()); } //
             * 如果开始时间没有 结束时间有 if (IsNotNullUtil.isNotNull(condition.getdeptEndTime()) &&
             * IsNotNullUtil.isNotNullWithOr(condition.getDeptStartTime())) {
             * createCriteria.andCreatetimeLessThan(condition.getdeptEndTime()); } //
             * 如果开始时间有 且结束时间也有 if (IsNotNullUtil.isNotNull(condition.getdeptEndTime())&&
             * IsNotNullUtil.isNotNull(condition.getDeptStartTime())) {
             * createCriteria.andCreatetimeBetween(condition.getDeptStartTime(),
             * condition.getdeptEndTime()); } // 排序判断
             * if(IsNotNullUtil.isNotNull(bootstrapDataTable.getSort())&&IsNotNullUtil.
             * isNotNull(bootstrapDataTable.getOrder())) {
             * deptExample.setOrderByClause(bootstrapDataTable.getSort()+"  "
             * +bootstrapDataTable.getOrder()); } deptExample.or(createCriteria2);
             */
        }
        // 分页
        List<Dept> list = deptMapper.selectByExample(deptExample);
        // 设置上级部门名称
        for (Dept dept : list) {
            if (IsNotNullUtil.isNotNull(dept.getPid())) {
                dept.setpName(deptMapper.selectByPrimaryKey(dept.getPid()).getDeptname());
            }
        }
        // 实例化PageInfo
        BootstrapDataTable dataTable = new BootstrapDataTable();
        // 设置总记录数和总数
        dataTable.setTotal(list.size());
        dataTable.setRows(list);
        return dataTable;
    }

    /**
     * 查询出所有的部门名称
     */
    @Override
    public List<Dept> selectByExample(DeptExample example) {
        //实例化查询对象
        DeptExample example2 = new DeptExample();
        //实例化条件对象
        Criteria criteria = example2.createCriteria();
        //只查询未删除状态的
        criteria.andDeletestatusEqualTo(0);
        List<Dept> depts = deptMapper.selectByExample(example2);
        for (Dept dept : depts) {
            dept.setName(dept.getDeptname());
        }
        return depts;
    }

    /**
     * 根据主键单个查询
     */
    @Override
    public Dept selectByPrimaryKey(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改部门信息
     */
    @Override
    public boolean updateByPrimaryKeySelective(Dept record) {
        // 删除状态
        record.setDeletestatus(0);
        try {
            deptMapper.updateByPrimaryKeySelective(record);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加一条部门信息
     */
    @Override
    public boolean insertSelective(Dept record) {
        // 删除状态
        record.setDeletestatus(0);
        // 创建时间
        record.setCreatetime(new Date());
        try {
            deptMapper.insertSelective(record);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据部门名称查询部门信息
     */
    @Override
    public Map<String, Boolean> selectByName(String deptname) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = false;
        Dept dept = deptMapper.selectByName(deptname);
        if (IsNotNullUtil.isNotNull(dept)) {
            result = false;
        } else {
            result = true;
        }
        map.put("valid", result);
        return map;
    }

    /*
     * 查找子节点
     */
    // 子节点集合
    List<Integer> pids = null;

    @Override
    public boolean findNode(Integer id, Integer pid) {
        pids = new ArrayList<Integer>();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(id);
        return selectSon(pid, ids);
    }

    /**
     * 查询是否有子节点
     *
     * @param pid
     * @param ids
     * @return
     */
    private boolean selectSon(Integer pid, List<Integer> ids) {
        List<Integer> sonIds = deptMapper.selectDeptSonNode(ids);
        for (Integer p : sonIds) {
            pids.add(p);
        }
        if (sonIds != null && !sonIds.isEmpty()) {
            selectSon(pid, sonIds);
        }
        if (!pids.contains(pid)) {
            return true;
        }
        return false;
    }

    /**
     * 删除部门信息
     */
    @Override
    public void delete(Integer id) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(id);
        del(list);
    }

    /**
     * 查询部门以及下面的子部门
     *
     * @param id
     */
    private void del(List<Integer> id) {
        // 删除父节点
        deptMapper.deleteDeptId(id);
        // 查询父节点所有子节点
        List<Integer> sonNode = deptMapper.selectDeptSonNode(id);
        if (sonNode != null && !sonNode.isEmpty()) {
            del(sonNode);
        }

    }

}
