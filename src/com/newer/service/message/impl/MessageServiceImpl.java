package com.newer.service.message.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.message.MessageMapper;
import com.newer.pojo.message.Message;
import com.newer.pojo.message.MessageExample;
import com.newer.service.message.MessageService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.IsNotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/27 0027 - 9:39
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public BootstrapDataTable selectAllMessage(BootstrapDataTable bootstrapDataTable, String Search) {
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(bootstrapDataTable.getOffset()) && IsNotNullUtil.isNotNull(bootstrapDataTable.getLimit())) {
            PageHelper.offsetPage(bootstrapDataTable.getOffset(), bootstrapDataTable.getLimit());
        }

        // 实例化student条件对象
        MessageExample example = new MessageExample();

        // 去重
        example.setDistinct(true);
        // 排序
        if (IsNotNullUtil.isNotNull(bootstrapDataTable.getSort()) && IsNotNullUtil.isNotNull(bootstrapDataTable.getOrder())) {
            example.setOrderByClause(bootstrapDataTable.getSort() + " " + bootstrapDataTable.getOrder());
        }

        // 实例筛选对象
        MessageExample.Criteria criteria1 = example.createCriteria();
        MessageExample.Criteria criteria2 = example.createCriteria();

        if (Search != null && !Search.trim().equals("")) {
            criteria1.andCommandLike("%" + Search + "%");
            criteria2.andDescriptionLike("%" + Search + "%");
            example.or(criteria2);
        }

        // 查询用户列表
        List<Message> selectByExample = messageMapper.selectByExample(example);

        // 实例一个PageInfo对象 ，并设置参数userlist
        PageInfo<Message> messagePageInfo = new PageInfo<Message>(selectByExample);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();

        // 设置值
        bootDataTable.setTotal((int) messagePageInfo.getTotal());
        bootDataTable.setRows(messagePageInfo.getList());

        // 返回对象
        return bootDataTable;
    }

    @Override
    public Message selectByid(Integer id) {
        return this.messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateMes(Message message) {
        boolean b = false;
        int i = this.messageMapper.updateByPrimaryKey(message);
        if (i > 0) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean deleteMes(Integer id) {
        boolean b = false;
        int i = this.messageMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean insertMes(Message message) {
        boolean b = false;
        int i = this.messageMapper.insert(message);
        if (i > 0) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean batchDeleteMes(String ids) {
        boolean b = false;
        // 然后使用split方法将字符串拆解到字符串数组中
        String[] strArr = ids.split(",");
        // 定义一个长度与上述的字符串数组长度相通的整型数组
        Integer[] intArr = new Integer[strArr.length];
        for (int a = 0; a < strArr.length; a++) {
            // 然后遍历字符串数组，使用包装类Integer的valueOf方法将字符串转为整型
            intArr[a] = Integer.valueOf(strArr[a]);
        }
        for (int s = 0; s < intArr.length; s++) {
            System.out.println(intArr[s]);
        }
        if (this.messageMapper.deleteUserByIds(intArr) > 0) {
            b = true;
        }
        return b;
    }

    @Override
    public List findAll() {
        MessageExample example = new MessageExample();
        return this.messageMapper.selectByExample(example);
    }
}
