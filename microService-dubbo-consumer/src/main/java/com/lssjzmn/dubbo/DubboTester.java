package com.lssjzmn.dubbo;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.manager.department.api.DepartmentManager;
import com.lssjzmn.manager.doctor.api.DoctorManager;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DubboTester {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private DepartmentManager departmentManager;

    @Reference
    private DoctorManager doctorManager;

    //@PostConstruct
    public void test() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clas", "R2");
        List<Integer> rankRange = new ArrayList<>();
        rankRange.add(18);
        rankRange.add(29);

        List<Department> departments = departmentManager.findDepartmentsByClas(paramMap);
        System.out.println("DubboTester departments" + departments.toString());

        List<Doctor> doctorList = doctorManager.findDoctorsByDeptId(departments.get(0), -1, rankRange);
        System.out.println("DubboTester doctorList" + doctorList.toString());
    }
}
