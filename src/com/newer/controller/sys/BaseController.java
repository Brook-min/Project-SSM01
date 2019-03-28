package com.newer.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Base;
import com.newer.service.sys.BaseService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 基础数据管理
 *
 * @author yangming
 */
@RequestMapping("/base")
@Controller
public class BaseController {

    @Autowired
    private BaseService baseService;

    /**
     * 根据条件分页查询角色数据
     *
     * @param bootstrapDataTable
     * @return
     */
    @RequestMapping("/select")
    public @ResponseBody
    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, Condition condition) {
        BootstrapDataTable table = baseService.listAll(bootstrapDataTable, condition);
        return table;
    }

    /**
     * 批量删除基础数据
     *
     * @param ids
     * @return
     */
    @RequestMapping("/batchdelete")
    public @ResponseBody
    MsgUtil batchDelete(String ids) {
        boolean flag = baseService.batchDelete(ids);
        if (flag) {
            return MsgUtil.result(true, "删除成功！");
        } else {
            return MsgUtil.result(false, "系统繁忙,请稍后再试！");
        }
    }

    /**
     * 根据id查询基础信息
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable("id") Integer id, HttpServletRequest request) {
        request.setAttribute("base", baseService.selectByPrimaryKey(id));
        return JumpUtil.BASE_EDIT;
    }

    /**
     * 修改基础信息
     *
     * @param base
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public MsgUtil edit(Base base) {
        boolean flag = baseService.updateByPrimaryKeySelective(base);
        if (flag) {
            return MsgUtil.result(true, "修改成功!");
        } else {
            return MsgUtil.result(true, "修改失败!");
        }
    }

    /**
     * 添加一条基础信息
     *
     * @param base
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public MsgUtil add(Base base) {
        boolean flag = baseService.insertSelective(base);
        if (flag) {
            return MsgUtil.result(true, "添加成功!");
        } else {
            return MsgUtil.result(true, "添加失败!");
        }
    }

    /**
     * 删除一条基础信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public MsgUtil delete(@PathVariable("id") Integer id) {
        boolean flag = baseService.deleteByPrimaryKey(id);
        if (flag) {
            return MsgUtil.result(true, "删除成功!");
        } else {
            return MsgUtil.result(true, "删除失败!");
        }
    }

    /**
     * 信息来源
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/infoSource")
    @ResponseBody
    public List<Base> infoSource(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 咨询分类 market
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/consult")
    @ResponseBody
    public List<Base> consult(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 市场分类
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/market")
    @ResponseBody
    public List<Base> market(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 目前状态
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/state")
    @ResponseBody
    public List<Base> state(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 咨询进度
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/schedule")
    @ResponseBody
    public List<Base> schedule(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 学历
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/education")
    @ResponseBody
    public List<Base> education(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 关联人关系
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/relation")
    @ResponseBody
    public List<Base> relation(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 专业
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/major")
    @ResponseBody
    public List<Base> major(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 专业
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/system")
    @ResponseBody
    public List<Base> system(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 学生分类
     *
     * @param name
     * @return
     */
    @RequestMapping("/studentType")
    @ResponseBody
    public List<Base> studentType(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }


    /**
     * 培训形式
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/trainingtype")
    @ResponseBody
    public List<Base> trainingType(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }

    /**
     * 进班班级
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/shiftclass")
    @ResponseBody
    public List<Base> shiftClass(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }


    /**
     * 班主任
     *
     * @param name 名称
     * @return
     */
    @RequestMapping("/headmaster")
    @ResponseBody
    public List<Base> headmaster(@RequestParam("name") String name) {
        return baseService.selectByName(name);
    }


}
