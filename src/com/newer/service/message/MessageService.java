package com.newer.service.message;

import com.newer.pojo.message.Message;
import com.newer.util.sys.BootstrapDataTable;

import java.util.List;

/**
 * @author Brook_min
 * @date 2019/3/27 0027 - 9:37
 */
public interface MessageService {
    public List findAll();

    public BootstrapDataTable selectAllMessage(BootstrapDataTable bootstrapDataTable, String Search);

    public Message selectByid(Integer id);

    public boolean updateMes(Message message);

    public boolean deleteMes(Integer id);

    public boolean batchDeleteMes(String ids);

    public boolean insertMes(Message message);
}
