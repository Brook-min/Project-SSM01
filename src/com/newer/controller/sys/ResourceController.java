package com.newer.controller.sys;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Resource;
import com.newer.service.sys.ResourceService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 资源信息控制层
 *
 * @author LiuKang
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

    // 自动注入
    @Autowired
    private ResourceService resourceService;

    /**
     * 查询出资源网格视图表
     *
     * @return
     */
    @RequestMapping(value = "select", method = RequestMethod.GET)
    @ResponseBody
    public BootstrapDataTable treeGrid() {
        return resourceService.treeGrid();
    }

    /**
     * 资源树
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree", method = RequestMethod.GET)
    public List<Resource> tree() {
        return resourceService.tree();
    }

    /**
     * 根据主键单个查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public String selectById(Integer id, Model model) {
        model.addAttribute("resource", resourceService.selectById(id));
        return JumpUtil.RESOURCE_EDIT;
    }

    /**
     * 修改资源
     *
     * @param resource
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public MsgUtil update(Resource resource) {
        return resourceService.updateResource(resource);
    }

    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public MsgUtil add(Resource resource, HttpSession session) {
        MsgUtil addResource = resourceService.addResource(resource);
        /*loginout(session, addResource);*/
        return addResource;

    }

    /**
     * 删除资源 1.删除角色资源表中的资源信息 2.删除子级资源 3.删除本级资源
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public MsgUtil delete(@PathVariable("id") Integer id, HttpSession session) {
        MsgUtil deleteResource = resourceService.deleteResource(id);
	/*	//注销登录
		loginout(session, deleteResource);*/
        return deleteResource;
    }

    /**
     * 资源操作成功设置session失效
     * @param session
     * @param msgUtil
     */
/*	private void loginout(HttpSession session, MsgUtil msgUtil) {
		if (msgUtil.isFlag()) {
			// 设置session失效
			session.invalidate();
		}
	}*/

    /**
     * 修改状态
     *
     * @param resource
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    public MsgUtil updateStatus(Resource resource, HttpSession session) {
        try {
            resourceService.update(resource);
			/*//销毁session
			session.invalidate();*/
            return MsgUtil.result(true, "操作成功,请重新登录!");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙!");
        }

    }
}
