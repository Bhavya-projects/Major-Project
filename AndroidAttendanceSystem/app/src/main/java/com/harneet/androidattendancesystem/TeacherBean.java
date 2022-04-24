package com.harneet.androidattendancesystem;

/**
 * Created by Windows-10 on 10/15/2018.
 */

public class TeacherBean {
    private String status;
    TeacherBean(String x){
        this.status=x;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
