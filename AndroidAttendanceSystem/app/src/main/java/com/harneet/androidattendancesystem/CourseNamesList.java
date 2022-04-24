package com.harneet.androidattendancesystem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Windows-10 on 10/17/2018.
 */

public class CourseNamesList {
    @SerializedName("course_name")
    String course_name;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
