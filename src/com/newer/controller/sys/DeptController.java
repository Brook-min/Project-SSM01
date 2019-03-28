package com.newer.controller.sys;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Dept;
import com.newer.service.sys.DeptService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 部门信息控制层
 *
 * @author 卿超
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    //注入service层
    @Autowired
    private DeptService deptService;

    /**
     * 根据条件分页查询
     *
     * @param bootstrapDataTable
     * @return
     */
    @RequestMapping("select")
    @ResponseBody
    public BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable) {
        BootstrapDataTable table = deptService.listAll(bootstrapDataTable);
        return table;
    }

    /**
     * 异步查看所有部门
     *
     * @return
     */
    @RequestMapping("Tree")
    @ResponseBody
    public List<Dept> Tree() {
        return deptService.selectByExample(null);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("selectById/{id}")
    public String selectById(@PathVariable("id") Integer id, HttpServletRequest request) {
        request.setAttribute("dept", deptService.selectByPrimaryKey(id));
        return JumpUtil.DEPT_EDIT;
    }


    /**
     * 修改部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public MsgUtil update(Dept dept) {
        try {
            //避免设置父节点为该节点本身
            if (dept.getId() == dept.getPid()) {
                return MsgUtil.result(true, "修改成功");
            }
            //避免父节点放入子节点
            //通过id查询到该部门的子节点
            boolean flag = deptService.findNode(dept.getId(), dept.getPid());
            if (!flag) {
                return MsgUtil.result(false, "不能将此部门设置到下级部门!");
            } else {
                deptService.updateByPrimaryKeySelective(dept);
                return MsgUtil.result(true, "修改成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return MsgUtil.result(false, "系统繁忙!!");
        }
    }

    /**
     * 添加一条部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public MsgUtil add(Dept dept) {
        boolean insert = deptService.insertSelective(dept);
        if (insert) {
            return MsgUtil.result(true, "添加成功");
        }
        return MsgUtil.result(false, "添加失败");
    }

    /**
     * 异步判断
     * 根据部门名称查询是否有该部门
     *
     * @param deptname
     * @return
     */
    @RequestMapping("selectByName")
    @ResponseBody
    public Map<String, Boolean> selectByName(@RequestParam("deptname") String deptname) {
        return deptService.selectByName(deptname);
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public MsgUtil delete(@PathVariable("id") Integer id) {
        try {
            deptService.delete(id);
            return MsgUtil.result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MsgUtil.result(false, "删除失败");
    }

}
