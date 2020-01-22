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
 * Failover(失败自动切换)
 * Failover是高可用系统中的一个常用概念，服务器通常拥有主备两套机器配置，如果主服务器出现故障，则自动切换到备服务器中，从而保证了整体的高可用性。
 * <p>
 * Dubbo也借鉴了这个思想，并且把它作为Dubbo默认的容错策略。当调用出现失败的时候，根据配置的重试次数，会自动从其他可用地址中重新选择一个可用的地址进行调用，直到调用成功，或者是达到重试的上限。
 * <p>
 * Dubbo里默认配置的重试次数是2，也就是说，算上第一次调用，最多会调用3次。
 * <p>
 * 其配置方法，容错策略既可以在服务提供方配置，也可以服务调用方进行配置。而重试次数的配置则更为灵活，既可以在服务级别进行配置，也可以在方法级别进行配置。具体优先顺序为：
 * <p>
 * 服务调用方方法级配置 > 服务调用方服务级配置 > 服务提供方方法级配置 > 服务提供方服务级配置
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
        System.out.println("dubbo service DepartmentManagerImp called");
        List<Integer> rankRange = new ArrayList<>();
        rankRange.add(18);
        rankRange.add(29);
        Department dept = new Department();
        dept.setId("uehe003fh835fh934");
        List<Doctor> ret = doctorManager.findDoctorsByDeptId(dept, -1, rankRange);
        return departmentService.findDepartmentsByClas(params);
    }
}
