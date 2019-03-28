package com.newer.service.sys;

import java.util.List;
import java.util.Map;

import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.examples.DeptExample;
import com.newer.util.sys.BootstrapDataTable;

/**
 * 部门业务逻辑处理接口
 *
 * @author 卿超
 */
public interface DeptService {

    /**
     * 根据分页条件查询部门
     *
     * @param bootstrapDataTable 数据表格
     * @return
     */
    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable);

    /**
     * 按条件查询所有
     *
     * @param example
     * @return
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * 根据Id查询部门
     *
     * @param id
     * @return
     */
    Dept selectByPrimaryKey(Integer id);


    /**
     * 修改部门信息
     *
     * @param record
     * @return
     */
    boolean updateByPrimaryKeySelective(Dept record);

    /**
     * 添加一条部门信息
     *
     * @param record
     * @return
     */
    boolean insertSelective(Dept record);

    /**
     * 根据部门名称查询
     *
     * @param deptname
     * @return
     */
    Map<String, Boolean> selectByName(String deptname);

    /**
     * 是否子节点
     *
     * @param id
     * @param pid
     * @return
     */
    boolean findNode(Integer id, Integer pid);

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    void delete(Integer id);


}
