package com.lssjzmn.dao;

import com.lssjzmn.entity.Department;
import com.lssjzmn.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface DoctorDaoMapper {

    List<Doctor> findDoctorsByDeptId(@Param("dept") Department department,
                                     @Param("age") Integer age,
                                     @Param("rankRange") List rankRange);

    List<Doctor> findDoctorsByPaging();

    int saveDoctor(@Param("doctor") Doctor doctor);

    int saveDoctorList(@Param("doctors") List<Doctor> doctors);

}
