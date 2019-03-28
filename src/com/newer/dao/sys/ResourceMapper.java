package com.newer.dao.sys;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Resource;
import com.newer.pojo.sys.examples.ResourceExample;

@Repository("resourceMapper")
public interface ResourceMapper {

    /**
     * 根据条件对象查询记录数
     *
     * @param example
     * @return
     */
    long countByExample(ResourceExample example);

    /**
     * 根据条件对象删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ResourceExample example);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入资源信息
     *
     * @param record
     * @return
     */
    int insert(Resource record);

    /**
     * 根据指定信息插入
     *
     * @param record
     * @return
     */
    int insertSelective(Resource record);

    /**
     * 根据条件对象查询
     *
     * @param example
     * @return
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    Resource selectByPrimaryKey(Integer id);

    /**
     * 根据条件对象和指定信息修改
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * 根据条件对象修改
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * 根据主键和指定信息修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * 根据主键修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Resource record);

    /**
     * 查询出资源管理信息
     *
     * @param userId
     * @return
     */
    List<Resource> selectTreeGrid();

    /**
     * 根据用户编号查询用户资源
     *
     * @param userId
     * @return
     */
    Set<String> selectResourcesList(Integer userId);

    /**
     * 查询资源的子节点
     *
     * @param ids
     * @return
     */
    List<Integer> selectResourceSonNode(@Param("ids") List<Integer> ids);


    /**
     * 删除角色资源表信息
     *
     * @param id
     */
    @Delete("delete from  tb_role_resource where resourceid=#{id}")
    void deleteRoleResource(@Param("id") Integer id);

    /**
     * 根据用户编号查询出左侧菜单栏
     *
     * @param userId
     * @return
     */
    List<Resource> selectMenu(Integer userId);
}