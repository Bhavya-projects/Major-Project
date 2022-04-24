package com.harneet.androidattendancesystem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Windows-10 on 3/30/2019.
 */

public class GetAllTeacherNameForViewFeedback {
    @SerializedName("teacher_name")
    String teacher_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
