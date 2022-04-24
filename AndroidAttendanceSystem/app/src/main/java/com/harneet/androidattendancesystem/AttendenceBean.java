package com.harneet.androidattendancesystem;

import java.util.ArrayList;

/**
 * Created by Windows-10 on 10/29/2018.
 */

public class AttendenceBean {

    private ArrayList<String> studentname;
    private ArrayList<String> arraystatus;
    private String teachername;
    private String sem;
    private String branch;

    public ArrayList<String> getStudentname() {
        return studentname;
    }

    public void setStudentname(ArrayList<String> studentname) {
        this.studentname = studentname;
    }

    public ArrayList<String> getArraystatus() {
        return arraystatus;
    }

    public void setArraystatus(ArrayList<String> arraystatus) {
        this.arraystatus = arraystatus;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
