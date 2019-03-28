package com.newer.controller.student;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.student.Subject;
import com.newer.service.student.SubjectService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.MsgUtil;

@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 进入查询页面
     *
     * @return
     */
    @RequestMapping("manager")
    public String manager() {
        return "student/subject/subject";
    }

    /**
     * 按条件查询，分页
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    @RequestMapping("select")
    public @ResponseBody
    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, String subName) {
        BootstrapDataTable table = subjectService.listAll(bootstrapDataTable, subName);
        return table;
    }

    /**
     * 科目添加的进入页面
     *
     * @return
     */
    @RequestMapping("add")
    public String add() {
        return "student/subject/subject_add";
    }

    /**
     * 保存科目
     *
     * @return
     */
    @RequestMapping("save")
    public @ResponseBody
    MsgUtil save(Subject subject) {
        try {
            subjectService.save(subject);
            return MsgUtil.result(true, "添加成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "添加失败！");
        }
    }


    /**
     * 判断科目名称是否存在
     */
    @RequestMapping("checkSubName")
    public @ResponseBody
    Map<String, Boolean> checkRoleName(String subName) {
        Map<String, Boolean> result = subjectService.checkSubName(subName);
        return result;
    }


}
