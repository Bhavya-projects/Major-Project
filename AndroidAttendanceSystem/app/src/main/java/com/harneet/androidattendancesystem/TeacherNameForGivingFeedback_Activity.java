package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 3/1/2019.
 */

public class TeacherNameForGivingFeedback_Activity extends Activity {
    private ListView lstteachernamesforfeedback;
    private String studentname;
    private ApiInterface apiInterface;
    private ArrayList<String> arraytname;
    AdapterClassForPrintTeacherName adapter2;
    private String teacherItem[];






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_teachernames_feedback_fragment);
        lstteachernamesforfeedback=(ListView)findViewById(R.id.listofteavhersforfeedback);
        Intent i1 =getIntent();
        studentname= i1.getStringExtra("student_name_for_fetching_teachers_names_for_feedback");
       // Intent i2=new Intent();
        //i2.putExtra("Student_name",studentname);

        Toast.makeText(TeacherNameForGivingFeedback_Activity.this,"Welcome " +studentname ,Toast.LENGTH_LONG).show();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        arraytname=new ArrayList<>();

        sendstudentname(studentname);


    }
    public void sendstudentname(String sname) {

        apiInterface.sendsnameforfetchingteachersforfeedback(sname).enqueue(new Callback<List<GetTeacherNameForFeedbackBean>>() {
            @Override
            public void onResponse(Call<List<GetTeacherNameForFeedbackBean>> call, Response<List<GetTeacherNameForFeedbackBean>> response) {
                if (response.isSuccessful()) {

                    if(arraytname.size()>0){
                        arraytname = null;
                        arraytname=new ArrayList<String>();
                    }
                    List<GetTeacherNameForFeedbackBean> getTeacherNameBeen = response.body();
                    teacherItem = new String[getTeacherNameBeen.size()];


                    for (int i = 0; i < getTeacherNameBeen.size(); i++) {
                        teacherItem[i] = getTeacherNameBeen.get(i).getTeacher();
                        arraytname.add(getTeacherNameBeen.get(i).getTeacher());

                    }
                    adapter2 = new AdapterClassForPrintTeacherName(TeacherNameForGivingFeedback_Activity.this, arraytname);
                    adapter2.notifyDataSetChanged();
                    lstteachernamesforfeedback.setAdapter(adapter2);

                }


            }


            @Override
            public void onFailure(Call<List<GetTeacherNameForFeedbackBean>> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                //Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });

    }
}
