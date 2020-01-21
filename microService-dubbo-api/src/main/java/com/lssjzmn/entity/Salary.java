package com.lssjzmn.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salary")
public class Salary implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "STAFF_ID",referencedColumnName = "ID")
    private Doctor staffId;

    @Column(name = "TOTAL")
    private Float total;

    @Column(name = "AFTER")
    private Float after;

    @Column(name = "TYPE")
    private Character type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getStaffId() {
        return staffId;
    }

    public void setStaffId(Doctor staffId) {
        this.staffId = staffId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getAfter() {
        return after;
    }

    public void setAfter(Float after) {
        this.after = after;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }
}
