package com.lssjzmn.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dept")
public class Department implements Serializable{

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "ESTABLISH_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date establishTime;

    @Column(name = "KESHI_NUM")
    private Integer keshiNum;

    @Column(name = "STAFF_NUM")
    private Integer staffNum;

    @Column(name = "CLASS")
    private String clas;

    @Column(name = "SITE_IP")
    private Integer siteIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public Integer getKeshiNum() {
        return keshiNum;
    }

    public void setKeshiNum(Integer keshiNum) {
        this.keshiNum = keshiNum;
    }

    public Integer getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public Integer getSiteIp() {
        return siteIp;
    }

    public void setSiteIp(Integer siteIp) {
        this.siteIp = siteIp;
    }
}
