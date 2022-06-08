package com.meass.todday_admin;

public class BloodBankModel {
    String name,phone,area,time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BloodBankModel() {
    }

    public BloodBankModel(String name, String phone, String area, String time) {
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.time = time;
    }
}
