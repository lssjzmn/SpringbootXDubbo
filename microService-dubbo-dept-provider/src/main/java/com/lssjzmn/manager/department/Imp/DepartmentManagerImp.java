package com.lssjzmn.manager.department.Imp;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.manager.department.api.DepartmentManager;
import com.lssjzmn.manager.doctor.api.DoctorManager;
import com.lssjzmn.service.api.DepartmentService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 既是提供者也是消费者
 */
@Service
@Component
public class DepartmentManagerImp implements DepartmentManager {

    @Autowired
    private DepartmentService departmentService;

    @Reference
    private DoctorManager doctorManager;

    @Override
    public List<Department> findDepartmentsByClas(Map params) {
        List<Integer> rankRange = new ArrayList<>();
        rankRange.add(18);
        rankRange.add(29);
        Department dept = new Department();
        dept.setId("uehe003fh835fh934");
        List<Doctor> ret = doctorManager.findDoctorsByDeptId(dept, -1, rankRange);
        return departmentService.findDepartmentsByClas(params);
    }
}
