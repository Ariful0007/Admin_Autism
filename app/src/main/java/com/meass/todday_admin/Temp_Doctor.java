package com.meass.todday_admin;


public class Temp_Doctor {
    String image, name, deg, gender, userPhone, location,
            bmdc, p_email, p_password, category, uuid, doctorfee, paymentMethode, paymentNumber, checkingtime, doctorDate;

    public Temp_Doctor() {
    }

    public Temp_Doctor(String image, String name, String deg, String gender,
                       String userPhone, String location, String bmdc, String p_email,
                       String p_password, String category, String uuid,
                       String doctorfee, String paymentMethode, String paymentNumber,
                       String checkingtime, String doctorDate) {
        this.image = image;
        this.name = name;
        this.deg = deg;
        this.gender = gender;
        this.userPhone = userPhone;
        this.location = location;
        this.bmdc = bmdc;
        this.p_email = p_email;
        this.p_password = p_password;
        this.category = category;
        this.uuid = uuid;
        this.doctorfee = doctorfee;
        this.paymentMethode = paymentMethode;
        this.paymentNumber = paymentNumber;
        this.checkingtime = checkingtime;
        this.doctorDate = doctorDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBmdc() {
        return bmdc;
    }

    public void setBmdc(String bmdc) {
        this.bmdc = bmdc;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDoctorfee() {
        return doctorfee;
    }

    public void setDoctorfee(String doctorfee) {
        this.doctorfee = doctorfee;
    }

    public String getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(String paymentMethode) {
        this.paymentMethode = paymentMethode;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getCheckingtime() {
        return checkingtime;
    }

    public void setCheckingtime(String checkingtime) {
        this.checkingtime = checkingtime;
    }

    public String getDoctorDate() {
        return doctorDate;
    }

    public void setDoctorDate(String doctorDate) {
        this.doctorDate = doctorDate;
    }
}
