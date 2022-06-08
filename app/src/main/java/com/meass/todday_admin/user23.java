package com.meass.todday_admin;

public class user23 {
    String user_id,name,skills,about,phone,email,image;

    public user23() {
    }

    public user23(String user_id,
                  String name, String skills, String about,
                  String phone, String email, String image) {
        this.user_id = user_id;
        this.name = name;
        this.skills = skills;
        this.about = about;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
