package com.meass.todday_admin;

public class Doctor_key {
    String email,doctor_key;

    public Doctor_key() {
    }

    public Doctor_key(String email, String doctor_key) {
        this.email = email;
        this.doctor_key = doctor_key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctor_key() {
        return doctor_key;
    }

    public void setDoctor_key(String doctor_key) {
        this.doctor_key = doctor_key;
    }
}
