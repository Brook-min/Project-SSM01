package com.newer.controller.sys;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Resource;
import com.newer.pojo.sys.Role;
import com.newer.service.sys.RoleService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 角色控制层
 *
 * @author 奉小军
 */
@Controller
@RequestMapping("role")
public class RoleController {

    // 注入role的 service层
    @Autowired
    private RoleService roleService;

    /**
     * 根据条件分页查询角色数据
     *
     * @param bootstrapDataTable
     * @return
     */
    @RequestMapping("select")
    public @ResponseBody
    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, Condition condition) {
        BootstrapDataTable table = roleService.listAll(bootstrapDataTable, condition);
        return table;
    }

    /**
     * 根据id查询角色
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("selectById/{id}")
    public String selectById(@PathVariable("id") Integer id, HttpServletRequest request) {
        request.setAttribute("role", roleService.selectById(id));
        return JumpUtil.ROLE_EDIT;
    }

    /**
     * 根据id查询角色
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("delete/{id}")
    public @ResponseBody
    MsgUtil deleteById(@PathVariable("id") Integer id) {
        try {
            roleService.fakeDelete(id);
            return MsgUtil.result(true, "删除成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "删除失败！");
        }
    }

    /**
     * 根据id修改角色
     */
    @RequestMapping("update")
    public @ResponseBody
    MsgUtil updateById(Role role) {
        try {
            roleService.updateRoleByid(role);
            return MsgUtil.result(true, "修改成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "修改失败！");
        }
    }

    /**
     * 判断角色名是否存在
     */
    @RequestMapping("checkRoleName")
    public @ResponseBody
    Map<String, Boolean> checkRoleName(String rolename) {
        Map<String, Boolean> result = roleService.checkRoleName(rolename);
        return result;
    }

    /**
     * 添加角色
     */
    @RequestMapping("add")
    public @ResponseBody
    MsgUtil addRole(Role role) {
        try {
            roleService.addRole(role);
            return MsgUtil.result(true, "添加成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "添加失败！");
        }
    }

    /**
     * 查询出资源树
     *
     * @return
     */
    @RequestMapping(value = "tree", method = RequestMethod.GET)
    @ResponseBody
    public List<Resource> tree() {
        return roleService.tree();
    }

    /**
     * 1.查询角色权限，显示权限信息
     */
    @RequestMapping("role_grant/{id}")
    public String torole_grant(@PathVariable("id") Integer id, HttpServletRequest request) {
        List<Integer> resourceIds = roleService.selJurisdictionByRoleId(id);
        String resourceids = "";
        for (int i = 0; i < resourceIds.size(); i++) {
            if (i < resourceIds.size() - 1) {
                resourceids += resourceIds.get(i) + ",";
            } else {
                resourceids += resourceIds.get(i);
            }
        }
        // 保存以逗号分隔的资源字符串id
        request.setAttribute("resourceids", resourceids);
        request.setAttribute("roleId", id);
        return JumpUtil.ROLE_GRANT;
    }

    /**
     * 批量删除角色
     */
    @RequestMapping("batchdelete/{ids}")
    public @ResponseBody
    MsgUtil deleteByIds(@PathVariable("ids") String ids) {
        try {
            roleService.deleteByIds(ids);
            return MsgUtil.result(true, "删除成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "删除失败！");
        }
    }

    /**
     * 角色授权
     */
    @RequestMapping("grant")
    public @ResponseBody
    MsgUtil grant(Integer roleId, String rids) {
        try {
            roleService.grant(roleId, rids);
            return MsgUtil.result(true, "授权成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "授权失败！");
        }
    }
}
