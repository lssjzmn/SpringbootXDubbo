package com.lssjzmn.service.api;

import com.lssjzmn.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Department> findDepartmentsByClas(Map params);

}
