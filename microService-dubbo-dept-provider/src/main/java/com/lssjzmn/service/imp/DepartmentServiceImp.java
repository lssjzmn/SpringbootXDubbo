package com.lssjzmn.service.imp;

import com.lssjzmn.dao.DepartmentDaoMapper;
import com.lssjzmn.entity.Department;
import com.lssjzmn.service.api.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component("departmentService")
@Transactional("transactionManager")
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentDaoMapper departmentDaoMapper;

    @Override
    public List<Department> findDepartmentsByClas(Map params) {
        return departmentDaoMapper.findDepartmentsByClas(params);
    }
}
