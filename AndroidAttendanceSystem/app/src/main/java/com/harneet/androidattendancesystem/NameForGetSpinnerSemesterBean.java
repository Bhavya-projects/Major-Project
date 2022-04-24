package com.harneet.androidattendancesystem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Windows-10 on 10/22/2018.
 */

public class NameForGetSpinnerSemesterBean {
    @SerializedName("semester")
    String semester;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
