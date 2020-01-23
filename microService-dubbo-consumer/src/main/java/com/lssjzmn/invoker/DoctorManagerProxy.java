package com.lssjzmn.invoker;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.manager.doctor.api.DoctorManager;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DoctorManagerProxy implements DoctorManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(timeout = 10000, check = false)
    private DoctorManager doctorManager;

    @Override
    public List<Doctor> findDoctorsByDeptId(Department department, Integer age, List rankRange) {
        logger.info("DoctorManagerProxy called");
        return doctorManager.findDoctorsByDeptId(department, age, rankRange);
    }

    @Override
    public List<Doctor> findDoctorsByPaging() {
        return doctorManager.findDoctorsByPaging();
    }

    @Override
    public int saveDoctor(Doctor doctor) {
        return doctorManager.saveDoctor(doctor);
    }

    @Override
    public int saveDoctorList(List<Doctor> doctors) {
        return doctorManager.saveDoctorList(doctors);
    }
}
