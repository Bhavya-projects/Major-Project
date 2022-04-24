package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * Created by Windows-10 on 9/17/2018.
 */

public class Add_Class_Fragment extends Fragment {
    private EditText course_name;
    private Spinner sem,teacher;
    private Button submitAddClass;
    private String item[]= {"1","2","3","4","5","6","7","8"};
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;
    private ApiInterface apiInterface;
    private TextView dummy,dummy1;
    private String teacherItem[];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_add_class_fragment,null);
        course_name=(EditText)v.findViewById(R.id.EditCourseName);
        sem=(Spinner)v.findViewById(R.id.spinsemester);
        teacher=(Spinner)v.findViewById(R.id.spinteacher);
        submitAddClass=(Button)v.findViewById(R.id.SubmitAddClass);
        dummy=(TextView)v.findViewById(R.id.dummy);
        dummy1=(TextView)v.findViewById(R.id.dummy1);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);


        apiInterface.getAllTeachersList().enqueue(new Callback<List<TeacherNameList>>() {
            @Override
            public void onResponse(Call<List<TeacherNameList>> call, Response<List<TeacherNameList>> response) {
                List<TeacherNameList> teacherNameLists = response.body();
                Log.e("Size :",""+teacherNameLists.get(0).getTeacher_name());
                teacherItem = new String[teacherNameLists.size()];

                for(int i=0;i<teacherNameLists.size();i++){
                    teacherItem[i]= teacherNameLists.get(i).getTeacher_name();
                    Log.e("name",teacherItem[i]= teacherNameLists.get(i).getTeacher_name());

                }

                adapter1= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,teacherItem);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                teacher.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<TeacherNameList>> call, Throwable t) {
                Log.e("Failure",t.getMessage());


            }
        });

        teacher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str1=teacherItem[position];
                dummy1.setText(str1);
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
                dummy.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(adapter);

        submitAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2,s3;
                s1 =course_name .getText().toString();
                s2 = dummy.getText().toString();
                s3 = dummy1.getText().toString();




                sendclassdetails(s1,s2,s3);

            }
        });

        return v;

    }


    public void sendclassdetails(String course_name, String semester,String teacher) {

        apiInterface.saveclassdetails(course_name, semester,teacher).enqueue(new Callback<ClassBean>() {
            @Override
            public void onResponse(Call<ClassBean> call, Response<ClassBean> response) {
                if (response.isSuccessful()) {
                    ClassBean classBean = response.body();
                    String status = classBean.getStatus();
                    if (status.equals("success")) {
                        Toast.makeText(getActivity(), "Succesfully inserted", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity(), "Insertion failed", Toast.LENGTH_LONG).show();

                    }

                }

            }



            @Override
            public void onFailure(Call<ClassBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });





    }
}
