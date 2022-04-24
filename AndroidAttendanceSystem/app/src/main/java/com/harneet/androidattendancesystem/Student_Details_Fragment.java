package com.harneet.androidattendancesystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 10/4/2018.
 */

public class Student_Details_Fragment extends Fragment {
    private EditText student_name,student_username,student_password,student_phone,student_emailid;
    private Spinner course_name,sem;
    private Button submitAddStudent;
    private ArrayAdapter<String> adapter;
    private ApiInterface apiInterface;
    private TextView dummy,dummy1;
    private String coursenames[];
    private String item[]= {"1","2","3","4","5","6","7","8"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_student_details_fragment,null);
        student_name=(EditText)v.findViewById(R.id.EditStudentName);
        student_username=(EditText)v.findViewById(R.id.EditStudentUserName);
        student_password=(EditText)v.findViewById(R.id.EditStudentPassword);
        student_phone=(EditText)v.findViewById(R.id.EditStudentPhoneNo);
        student_emailid=(EditText)v.findViewById(R.id.EditStudentEmailId);
        sem=(Spinner)v.findViewById(R.id.Spinsemester);

        course_name=(Spinner)v.findViewById(R.id.SpinStudent);
        submitAddStudent=(Button)v.findViewById(R.id.SubmitStudentDetails);
        dummy=(TextView)v.findViewById(R.id.dummy);
        dummy1=(TextView)v.findViewById(R.id.dummy1);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getAllcoursesList().enqueue(new Callback<List<CourseNamesList>>() {
            @Override
            public void onResponse(Call<List<CourseNamesList>> call, Response<List<CourseNamesList>> response) {
                List<CourseNamesList> courseNamesLists = response.body();
               // Log.e("Size :",""+courseNamesLists.get(0).getCourse_names());
                coursenames = new String[courseNamesLists.size()];

                for(int i=0;i<courseNamesLists.size();i++){
                    coursenames[i]= courseNamesLists.get(i).getCourse_name();

                }

                adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,coursenames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                course_name.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CourseNamesList>> call, Throwable t) {
                Log.e("Failure",t.getMessage());


            }
        });
        course_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str1=coursenames[position];
                dummy.setText(str1);
                // Log.e("str1",str1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str=item[position];
                dummy1.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(adapter);
        submitAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4,s5,s6,s7;
                s1 =student_name .getText().toString();
                s2 =student_username .getText().toString();
                s3 =student_password .getText().toString();
                s4 = dummy.getText().toString();

                s5 =student_phone .getText().toString();
                s6 =student_emailid .getText().toString();
                s7 = dummy1.getText().toString();
                if (Validators.validatename(s1))
                {
                    student_name.setError("invalid name");

                }
                else if (Validators.validatepass(s3))
                {
                    student_password.setError("password too short");

                }
                else if (Validators.validatephno(s5))
                {
                    student_phone.setError("invalid phone number");

                }
                else if (Validators.validateemail(s6))
                {
                    student_emailid.setError("invalid email");

                }
                else {
                    sendstudentdetails(s1,s2,s3,s4,s5,s6,s7);

                }









            }
        });



        return v;

    }

    public void sendstudentdetails(String sname, String suname,String password, String course_name , String phone, String email_id,String sem) {

        apiInterface.savestudentdetails(sname,suname,password,course_name,phone,email_id,sem).enqueue(new Callback<StudentBean>() {
            @Override
            public void onResponse(Call<StudentBean> call, Response<StudentBean> response) {
                if (response.isSuccessful()) {
                    StudentBean studentBean = response.body();
                    String status = studentBean.getStatus();
                    if (status.equals("success")) {
                        Toast.makeText(getActivity(), "Succesfully inserted", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity(), "Insertion failed", Toast.LENGTH_LONG).show();

                    }

                }

            }



            @Override
            public void onFailure(Call<StudentBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });





    }
}
