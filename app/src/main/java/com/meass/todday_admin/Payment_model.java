package com.meass.todday_admin;

public class Payment_model {
    String email,doctor_name,ammount,date;

    public Payment_model() {
    }

    public Payment_model(String email, String doctor_name, String ammount, String date) {
        this.email = email;
        this.doctor_name = doctor_name;
        this.ammount = ammount;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
