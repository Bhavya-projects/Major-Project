package com.harneet.androidattendancesystem;

/**
 * Created by Windows-10 on 10/16/2018.
 */

public class ClassBean {
    private String status;
    ClassBean(String x){
        this.status=x;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
