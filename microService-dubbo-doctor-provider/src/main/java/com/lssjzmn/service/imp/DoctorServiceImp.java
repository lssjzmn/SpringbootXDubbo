package com.lssjzmn.service.imp;

import com.lssjzmn.dao.DoctorDaoMapper;
import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import com.lssjzmn.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("doctorService")
@Transactional("transactionManager")
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorDaoMapper doctorDaoMapper;

    @Override
    public List<Doctor> findDoctorsByDeptId(Department department, Integer age, List rankRange) {
        return doctorDaoMapper.findDoctorsByDeptId(department, age, rankRange);
    }

    @Override
    public List<Doctor> findDoctorsByPaging() {
        return doctorDaoMapper.findDoctorsByPaging();
    }

    @Override
    public int saveDoctor(Doctor doctor) {
        return doctorDaoMapper.saveDoctor(doctor);
    }

    @Override
    public int saveDoctorList(List<Doctor> doctors) {
        return doctorDaoMapper.saveDoctorList(doctors);
    }
}
