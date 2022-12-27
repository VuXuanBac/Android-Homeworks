package com.example.qlsv;

import java.util.Date;

public class Student {

    public Student(String mssv, String name, String email, Date dob) {
        this.mssv = mssv;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private String mssv;
    private String name;
    private String email;
    private Date dob;


}
