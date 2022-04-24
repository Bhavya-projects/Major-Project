package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 3/30/2019.
 */

public class SepararteActivityForGivingFeedback extends Activity {
    String teachername,studentname;
    private Button btnsave,btncancel;
    private TextView teachernamespace;
    EditText editcomment;
    Spinner spinnerforrating;
    private String item[]= {"1","2","3","4","5"};
    private TextView dummy,studentnametextview;
    private ArrayAdapter<String> adapter;
    private ApiInterface apiInterface;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_for_separate_activitty);
        Intent i =getIntent();
        teachername = i.getStringExtra("teacher_name");
        Intent i1 =getIntent();
        studentname= i1.getStringExtra("student_name_for_fetching_teachers_names_for_feedback");
        teachernamespace=(TextView)findViewById(R.id.teachernamefromteacherlist);
        teachernamespace.setText(teachername);
        btnsave=(Button)findViewById(R.id.SaveBtn);
        btncancel=(Button)findViewById(R.id.CancelBtn);
        dummy=(TextView)findViewById(R.id.dummy);
        editcomment=(EditText)findViewById(R.id.edittextforfeedback);
        spinnerforrating=(Spinner)findViewById(R.id.spinnerforrating);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);


        spinnerforrating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str=item[position];
                dummy.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter= new ArrayAdapter<String>(SepararteActivityForGivingFeedback.this,android.R.layout.simple_spinner_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerforrating.setAdapter(adapter);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;
                s1 =teachernamespace.getText().toString();
                s2 = dummy.getText().toString();
                s3 = editcomment.getText().toString();
                sendfeedback(s1,s2,s3);
                //Toast.makeText(SepararteActivityForGivingFeedback.this, "Feedback Failed"+s1+s2+s3, Toast.LENGTH_LONG).show();


            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(SepararteActivityForGivingFeedback.this,AdapterClassForPrintTeacherName.class);
                //startActivity(i);

            }
        });


    }
    public void sendfeedback(String t_name,String ratings,String comment){
        apiInterface.savefeedback(t_name,ratings,comment).enqueue(new Callback<ClassBean>() {
            @Override
            public void onResponse(Call<ClassBean> call, Response<ClassBean> response) {
                if (response.isSuccessful()) {
                    ClassBean classBean = response.body();
                    String status = classBean.getStatus();
                    if (status.equals("success")) {
                        Toast.makeText(SepararteActivityForGivingFeedback.this, "Feedback Given Successfully", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(SepararteActivityForGivingFeedback.this, "Feedback Failed", Toast.LENGTH_LONG).show();

                    }

                }

            }



            @Override
            public void onFailure(Call<ClassBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(SepararteActivityForGivingFeedback.this, "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });
    }
}
