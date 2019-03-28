package com.newer.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.KeeponExample;

@Repository("keeponMapper")
public interface KeeponMapper {
    long countByExample(KeeponExample example);

    int deleteByExample(KeeponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Keepon record);

    int insertSelective(Keepon record);

    List<Keepon> selectByExample(KeeponExample example);

    Keepon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Keepon record, @Param("example") KeeponExample example);

    int updateByExample(@Param("record") Keepon record, @Param("example") KeeponExample example);

    int updateByPrimaryKeySelective(Keepon record);

    int updateByPrimaryKey(Keepon record);

    /**
     * 查找所有咨询师
     *
     * @return
     */
    List<User> selectConsultant();

    /**
     * 根据用户是否为咨询师或者主管查询备案信息
     *
     * @param uid
     * @param rolename
     * @param example
     * @return
     */
    List<Keepon> selectKeeponByRoleCode(KeeponExample keeponExample);

    /**
     * 根据市场专员这个条件高级查询备案信息
     *
     * @param example
     * @return
     */
    List<Keepon> selectKeeponByMarketer(KeeponExample keeponExample);

    /**
     * 根据市场专员这个条件高级查询备案信息
     *
     * @param example
     * @return
     */
    List<Keepon> selectKeeponByNet(KeeponExample keeponExample);

    /**
     * 根据市场主管这个条件高级查询备案信息
     *
     * @param example
     * @return
     */
    List<Keepon> selectKeeponByMarketing(KeeponExample keeponExample);

    /**
     * 根据id查询备案信息连接查询咨询表
     *
     * @param id
     * @return
     */
    Keepon selectKeeponWithConsultationById(Integer id);

    /**
     * 批量添加
     *
     * @param keepon
     * @return
     */
    boolean BatchInsert(@Param("keepon") List<Keepon> keepon);

    Keepon selectKeeponWithConsultationsById(Integer id);

    List<Keepon> selectByName(String studentname);

    List<Keepon> selectByTelephone(String telephone);

    List<Keepon> selectByQq(String qq);

    /**
     * 查看所有市场专员
     *
     * @return
     */
    List<User> selectMarker();
}