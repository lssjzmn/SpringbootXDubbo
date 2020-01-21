package com.lssjzmn.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "parking_io_record")
public class ParkingRecord implements Serializable{
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "park_name")
    private String parkingName;

    @Column(name = "io_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ioTime;

    @Column(name = "io_type")
    private Character ioType;

    @Column(name = "payed")
    private Character payed;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "money")
    private Float money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public Date getIoTime() {
        return ioTime;
    }

    public void setIoTime(Date ioTime) {
        this.ioTime = ioTime;
    }

    public Character getIoType() {
        return ioType;
    }

    public void setIoType(Character ioType) {
        this.ioType = ioType;
    }

    public Character getPayed() {
        return payed;
    }

    public void setPayed(Character payed) {
        this.payed = payed;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
