package com.example.zipcarrentalapp.Models;

import java.io.Serializable;

public class Order implements Serializable {
    private String customerName;
    private String carName;
    private int hireTime;
    private int outsideZoneDistance;

    public Order(String customerName, String carName, int hireTime, int outsideZoneDistance) {
        this.customerName = customerName;
        this.carName = carName;
        this.hireTime = hireTime;
        this.outsideZoneDistance = outsideZoneDistance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setHireTime(int hireTime) {
        this.hireTime = hireTime;
    }

    public void setOutsideZoneDistance(int outsideZoneDistance) {
        this.outsideZoneDistance = outsideZoneDistance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCarName() {
        return carName;
    }

    public int getHireTime() {
        return hireTime;
    }

    public int getOutsideZoneDistance() {
        return outsideZoneDistance;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", carName='" + carName + '\'' +
                ", hireTime=" + hireTime +
                ", outsideZoneDistance=" + outsideZoneDistance +
                '}';
    }
}
