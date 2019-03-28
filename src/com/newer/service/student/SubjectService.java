package com.newer.service.student;

import java.util.Map;

import com.newer.pojo.student.Subject;
import com.newer.util.sys.BootstrapDataTable;

public interface SubjectService {
    public BootstrapDataTable listAll(BootstrapDataTable dataTable, String subName);

    public void save(Subject subject);

    public Map<String, Boolean> checkSubName(String subName);
}
