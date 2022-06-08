package com.meass.todday_admin;

public class Message_user {
    String name;
    String image;
    String skills;
    String about;
    String phone;
    String email;
    String doctor_name, category;
    String paymentnumber, paymentTransation;

    public Message_user() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentnumber() {
        return paymentnumber;
    }

    public void setPaymentnumber(String paymentnumber) {
        this.paymentnumber = paymentnumber;
    }

    public String getPaymentTransation() {
        return paymentTransation;
    }

    public void setPaymentTransation(String paymentTransation) {
        this.paymentTransation = paymentTransation;
    }

    public Message_user(String name, String image, String skills, String about, String phone, String email,
                        String doctor_name, String category, String paymentnumber, String paymentTransation) {
        this.name = name;
        this.image = image;
        this.skills = skills;
        this.about = about;
        this.phone = phone;
        this.email = email;
        this.doctor_name = doctor_name;
        this.category = category;
        this.paymentnumber = paymentnumber;
        this.paymentTransation = paymentTransation;
    }
}