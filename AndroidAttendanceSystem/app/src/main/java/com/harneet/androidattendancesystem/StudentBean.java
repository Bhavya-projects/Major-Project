package com.harneet.androidattendancesystem;

/**
 * Created by Windows-10 on 10/17/2018.
 */

public class StudentBean {
    private String status;
    StudentBean(String x){
        this.status=x;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
