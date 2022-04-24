package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Windows-10 on 9/16/2018.
 */

public class Student_Page_Activity extends Activity {
    private Button btnStudentfeedback,btnStudentreport,btnLogout;
    private Fragment frag;
    private String studentname;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_student_page);
        Intent i =getIntent();
        studentname= i.getStringExtra("student_name");

        btnLogout=(Button)findViewById(R.id.btn_studentlogout);
        btnStudentfeedback=(Button)findViewById(R.id.btn_studentfeedback);
        btnStudentreport=(Button)findViewById(R.id.btn_studentreport);
        btnStudentreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag= new Student_Report_Fragment();
                loadFragment();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Student_Page_Activity.this, DemoInitialActivity.class);
                startActivity(i);
            }
        });
        btnStudentfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Student_Page_Activity.this,TeacherNameForGivingFeedback_Activity.class);
                i1.putExtra("student_name_for_fetching_teachers_names_for_feedback",studentname);
                startActivity(i1);
            }
        });
    }
    public void loadFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout_for_view_attendance, frag);
        ft.commit();
    }
    public String getMyData() {
        return studentname;
    }
}
