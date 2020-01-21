package com.lssjzmn.manager.department.api;

import com.lssjzmn.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentManager {

    List<Department> findDepartmentsByClas(Map params);

}
