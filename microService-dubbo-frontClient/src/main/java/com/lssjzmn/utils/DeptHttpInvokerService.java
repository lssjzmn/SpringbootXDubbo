package com.lssjzmn.utils;

import com.lssjzmn.manager.department.api.DepartmentManager;
import com.lssjzmn.util.AbstractHttpInvokerService;

public class DeptHttpInvokerService extends AbstractHttpInvokerService<DepartmentManager> {

    @Override
    public String setServiceUrl() {
        return "http://localhost:8081/deptManager";
    }

}
