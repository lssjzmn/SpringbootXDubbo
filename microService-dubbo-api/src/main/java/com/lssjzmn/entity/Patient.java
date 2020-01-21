package com.lssjzmn.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "CRED_CARD_NO")
    private String credCardNo;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "CATEGORY")
    private String category;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID",referencedColumnName = "ID")
    private Doctor doctorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCredCardNo() {
        return credCardNo;
    }

    public void setCredCardNo(String credCardNo) {
        this.credCardNo = credCardNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }
}
