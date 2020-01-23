package com.lssjzmn.manager.doctor.imp;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.manager.doctor.api.DoctorManager;
import com.lssjzmn.service.api.DoctorService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class DoctorManagerImp implements DoctorManager {

    @Autowired
    private DoctorService doctorService;

    @Override
    public List<Doctor> findDoctorsByDeptId(Department department, Integer age, List rankRange) {
        Doctor doctor = new Doctor();
        doctor.setAge(22);
        doctor.setCategory("111");
        doctor.setId("ivjeuevi43fjcweiw");
        List<Doctor> ret = new ArrayList<>();
        ret.add(doctor);
        System.out.println("dubbo service DoctorManagerImp called");
        return doctorService.findDoctorsByDeptId(department, age, rankRange);//TODO
        //return ret;
    }

    @Override
    public List<Doctor> findDoctorsByPaging() {
        return doctorService.findDoctorsByPaging();
    }

    @Override
    public int saveDoctor(Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @Override
    public int saveDoctorList(List<Doctor> doctors) {
        return doctorService.saveDoctorList(doctors);
    }
}
