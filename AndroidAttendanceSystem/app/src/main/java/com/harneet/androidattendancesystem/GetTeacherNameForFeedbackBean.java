package com.harneet.androidattendancesystem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Windows-10 on 3/2/2019.
 */

public class GetTeacherNameForFeedbackBean {
    @SerializedName("teacher")
    String teacher;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
