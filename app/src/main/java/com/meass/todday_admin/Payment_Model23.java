package com.meass.todday_admin;

public class Payment_Model23 {
    String doctor_name, pohnenumber, trans, ammount, date, uuid, email,image,checking_date,patient_name;

    public Payment_Model23() {
    }

    public Payment_Model23(String doctor_name, String pohnenumber, String trans,
                         String ammount, String date, String uuid, String email,
                         String image, String checking_date, String patient_name) {
        this.doctor_name = doctor_name;
        this.pohnenumber = pohnenumber;
        this.trans = trans;
        this.ammount = ammount;
        this.date = date;
        this.uuid = uuid;
        this.email = email;
        this.image = image;
        this.checking_date = checking_date;
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPohnenumber() {
        return pohnenumber;
    }

    public void setPohnenumber(String pohnenumber) {
        this.pohnenumber = pohnenumber;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChecking_date() {
        return checking_date;
    }

    public void setChecking_date(String checking_date) {
        this.checking_date = checking_date;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
}

