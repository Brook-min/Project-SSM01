package com.newer.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.examples.DeptExample;

/**
 * mapper层
 *
 * @author 卿超
 */
@Repository("deptMapper")
public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    /**
     * 根据部门名称查询部门信息
     *
     * @param deptname
     * @return
     */
    Dept selectByName(String deptname);

    /**
     * 查询部门的子节点
     *
     * @param ids
     * @return
     */
    List<Integer> selectDeptSonNode(@Param("ids") List<Integer> ids);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    boolean deleteDeptId(@Param("ids") List<Integer> id);
}