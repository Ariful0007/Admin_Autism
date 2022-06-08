package com.meass.todday_admin;

public class Counter {
    String email,counter;

    public Counter() {
    }

    public Counter(String email, String counter) {
        this.email = email;
        this.counter = counter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }
}
