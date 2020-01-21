package com.lssjzmn.service.api;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> findDoctorsByDeptId(Department department,
                                     Integer age,
                                     List rankRange);

    List<Doctor> findDoctorsByPaging();

    int saveDoctor(Doctor doctor);

    int saveDoctorList(List<Doctor> doctors);

}
