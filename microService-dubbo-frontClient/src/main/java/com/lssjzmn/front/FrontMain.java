package com.lssjzmn.front;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.manager.department.api.DepartmentManager;
import com.lssjzmn.manager.doctor.api.DoctorManager;
import com.lssjzmn.utils.DeptHttpInvokerService;
import com.lssjzmn.utils.DoctorHttpInvokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontMain {

    private static Logger logger = LoggerFactory.getLogger(FrontMain.class);

    public static void main(String[] ars) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clas", "R2");
        List<Integer> rankRange = new ArrayList<>();
        rankRange.add(18);
        rankRange.add(29);

        DeptHttpInvokerService deptHttpInvokerService = new DeptHttpInvokerService();
        DoctorHttpInvokerService doctorHttpInvokerService = new DoctorHttpInvokerService();

        DepartmentManager departmentManager = deptHttpInvokerService.getHttpInvokerService();
        List<Department> departments = departmentManager.findDepartmentsByClas(paramMap);
        System.out.println(" #InvokerTest departments ");

        DoctorManager doctorManager = doctorHttpInvokerService.getHttpInvokerService();
        Department dept = new Department();
        dept.setId("uehe003fh835fh934");

        List<Doctor> doctorList = doctorManager.findDoctorsByDeptId(dept, -1, rankRange);
        System.out.println("InvokerTest doctorList ");
        System.out.println("InvokerTest main ends ");

    }
}
