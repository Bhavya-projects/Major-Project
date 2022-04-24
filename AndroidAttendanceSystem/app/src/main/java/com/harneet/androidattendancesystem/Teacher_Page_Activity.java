package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 10/22/2018.
 */

public class Teacher_Page_Activity extends Activity {
    private Spinner semester;
    private Spinner course;
    private Button sbt,sbtAttendance;
    //private String item[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;
    private ApiInterface apiInterface;
    private TextView dummy, dummy1;
    private String coursenames[];
    private String semester1[];

    private ListView lstStudentName;
    private String studentItem[];

    private ArrayList<String> arraysname;
    AdapterClassWithRadioButton adapter2;
    private String teacherName;
    private String sem;
    private String branch;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_teacher_page);

        Intent i =getIntent();
        teacherName = i.getStringExtra("teacher_name");

        dummy = (TextView)findViewById(R.id.dummy);
        dummy1 = (TextView)findViewById(R.id.dummy1);
        semester = (Spinner)findViewById(R.id.spinsemesterforlistingstudent);
        course = (Spinner)findViewById(R.id.spinclassforlistingstudent);
        lstStudentName=(ListView)findViewById(R.id.listfortakingattendance);
        arraysname=new ArrayList<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.sendnameforcoursespinner(teacherName).enqueue(new Callback<List<NameForGetSpinnerBean>>() {
            @Override
            public void onResponse(Call<List<NameForGetSpinnerBean>> call, Response<List<NameForGetSpinnerBean>> response) {
                List<NameForGetSpinnerBean> nameForGetSpinnerBeen = response.body();
                // Log.e("Size :",""+courseNamesLists.get(0).getCourse_names());
                coursenames = new String[nameForGetSpinnerBeen.size()];

                for (int i = 0; i < nameForGetSpinnerBeen.size(); i++) {
                    coursenames[i] = nameForGetSpinnerBeen.get(i).getCourse_name();

                }

                adapter1 = new ArrayAdapter<String>(Teacher_Page_Activity.this, android.R.layout.simple_spinner_item,coursenames);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                course.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<NameForGetSpinnerBean>> call, Throwable t) {
                Log.e("Failure", t.getMessage());


            }
        });

        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str1 = coursenames[position];
                dummy.setText(str1);
                // Log.e("str1",str1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        apiInterface.sendnameforsemesterspinner(teacherName).enqueue(new Callback<List<NameForGetSpinnerSemesterBean>>() {
            @Override
            public void onResponse(Call<List<NameForGetSpinnerSemesterBean>> call, Response<List<NameForGetSpinnerSemesterBean>> response) {
                List<NameForGetSpinnerSemesterBean> nameForGetSpinnerSemesterBeen = response.body();
                // Log.e("Size :",""+courseNamesLists.get(0).getCourse_names());
                semester1 = new String[nameForGetSpinnerSemesterBeen.size()];

                for (int i = 0; i < nameForGetSpinnerSemesterBeen.size(); i++) {
                    semester1[i] = nameForGetSpinnerSemesterBeen.get(i).getSemester();

                }

                adapter1 = new ArrayAdapter<String>(Teacher_Page_Activity.this, android.R.layout.simple_spinner_item,semester1);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                semester.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<NameForGetSpinnerSemesterBean>> call, Throwable t) {
                Log.e("Failure", t.getMessage());


            }
        });


        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = semester1[position];
                dummy1.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       /* adapter = new ArrayAdapter<String>(Teacher_Page_Activity.this, android.R.layout.simple_spinner_item,semester1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter);*/


        sbt = (Button)findViewById(R.id.submitforgettingstudentlist);
        sbtAttendance = (Button)findViewById(R.id.submitAttendance);
        sbtAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adapter2.sendDataToDatabase();
                //Toast.makeText(Teacher_Page_Activity.this,"teacher name "+teacherName,Toast.LENGTH_LONG).show();
                 Toast.makeText(Teacher_Page_Activity.this,"Succesfully Attendance Taken",Toast.LENGTH_LONG).show();
                Intent i = new Intent(Teacher_Page_Activity.this, DemoInitialActivity.class);
                startActivity(i);


            }
        });

        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2;
                s2 = dummy.getText().toString();
                s1 = dummy1.getText().toString();
                branch = dummy.getText().toString();
                sem = dummy1.getText().toString();
                senddetails(s1,s2);

                // frag = new PrintTeacherList_Fragment();
                //loadFragment();


            }
        });
    }



    public void senddetails(String semester, String course_name) {

        apiInterface.senddataforgettingstudentname(semester,course_name).enqueue(new Callback<List<GetStudentNameBean>>() {
            @Override
            public void onResponse(Call<List<GetStudentNameBean>> call, Response<List<GetStudentNameBean>> response) {
                if (response.isSuccessful()) {
                    if(arraysname.size()>0){
                        arraysname = null;
                        arraysname=new ArrayList<String>();
                    }
                    List<GetStudentNameBean> getStudentNameBeen = response.body();
                    studentItem = new String[getStudentNameBeen.size()];


                    for (int i = 0; i < getStudentNameBeen.size(); i++) {
                        studentItem[i] = getStudentNameBeen.get(i).getStudent_name();
                        arraysname.add(getStudentNameBeen.get(i).getStudent_name());

                    }
                    adapter2 = new AdapterClassWithRadioButton(Teacher_Page_Activity.this,arraysname,apiInterface,teacherName,sem,branch);
                    lstStudentName.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();



                }

            }


            @Override
            public void onFailure(Call<List<GetStudentNameBean>> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(Teacher_Page_Activity.this, "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });

    }
}

