package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Windows-10 on 9/14/2018.
 */

public class Admin_Page_Activity extends Activity {
    private Button btnaddteacher,btnaddclass,btnaddstudent,btnvieweditdetails,btnreports,btnfeedback,btnlogout;
    private Fragment frag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_admin_main_page);
        btnaddclass=(Button)findViewById(R.id.btn_addclass);
        btnaddteacher=(Button)findViewById(R.id.btn_addteacher);
        btnaddstudent=(Button)findViewById(R.id.btn_addstudent);
        btnvieweditdetails=(Button)findViewById(R.id.btn_viewedit);
        btnreports=(Button)findViewById(R.id.btn_report);
        btnfeedback=(Button)findViewById(R.id.btn_feedback);
        btnlogout=(Button)findViewById(R.id.btn_logout);

        btnaddclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag= new Add_Class_Fragment();
                loadFragment();

            }
        });

        btnaddteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag= new AddTeacherFragment();
                loadFragment();

            }
        });
        btnaddstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new Student_Details_Fragment();
                loadFragment();
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin_Page_Activity.this, DemoInitialActivity.class);
                startActivity(i);
                Toast.makeText(Admin_Page_Activity.this,"Successfull Logout",Toast.LENGTH_LONG).show();
            }
        });
        btnvieweditdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new ViewDetails_Fragment();
                loadFragment();



            }
        });
        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new View_Feedback_Fragment();
                loadFragment();



            }
        });


    }
    public void loadFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.contentContainer, frag);
        ft.commit();
    }
}
