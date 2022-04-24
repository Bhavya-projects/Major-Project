package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 4/5/2019.
 */

public class SeprateActivityForViewingFeedback extends Activity {
    private Button btnViewRating;
    private TextView teachernamespace,textfeedbackpace;
    EditText editfromdate,edittodate;
    //private TextView dummy,studentnametextview;
    private ArrayAdapter<String> adapter;
    private ApiInterface apiInterface;
    String teachername;
    private ImageView imageView;
    float fvalue;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_for_separate_view_feedback_activity);
        Intent i = getIntent();
        teachername = i.getStringExtra("teacher_name");
        teachernamespace = (TextView) findViewById(R.id.teachernamefromteacherlistforviewfeedback);
        textfeedbackpace = (TextView) findViewById(R.id.textfeedback);

        teachernamespace.setText(teachername);
        btnViewRating = (Button) findViewById(R.id.viewstar);
        editfromdate = (EditText) findViewById(R.id.edittextforfromdate);
        edittodate = (EditText) findViewById(R.id.edittextfortodate);
        imageView=(ImageView)findViewById(R.id.imageofstar);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnViewRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2, s3;
                s1 = teachernamespace.getText().toString();
                s2 = editfromdate.getText().toString();
                s3 = edittodate.getText().toString();
                sendDetailForViewStar(s1, s2, s3);
                //Toast.makeText(SepararteActivityForGivingFeedback.this, "Feedback Failed"+s1+s2+s3, Toast.LENGTH_LONG).show();


            }
        });
    }
    public void sendDetailForViewStar(String t_name,String fromdate,String todate){
        apiInterface.sendDetailForViewStar(t_name,fromdate,todate).enqueue(new Callback<ClassBean>() {
            @Override
            public void onResponse(Call<ClassBean> call, Response<ClassBean> response) {
                if (response.isSuccessful()) {
                    ClassBean classBean = response.body();
                    String status = classBean.getStatus();
                    fvalue=Float.parseFloat(status);


                    if(fvalue>=0.5 && fvalue<=1){
                        imageView.setImageResource(R.mipmap.fivestar);
                        textfeedbackpace.setText("'Very Good'");

                    }else if (status.equals("student")) {
                        imageView.setImageResource(R.mipmap.fourstar);
                        textfeedbackpace.setText("'Good'");

                    } else if (status.equals("student")){
                        imageView.setImageResource(R.mipmap.threestar);
                        textfeedbackpace.setText("'Average'");

                    }else if (status.equals("student")){
                        imageView.setImageResource(R.mipmap.twostar);
                        textfeedbackpace.setText("'Below Average'");


                    }else if (status.equals("student")){
                        imageView.setImageResource(R.mipmap.onestar);
                        textfeedbackpace.setText("'Bad'");


                    }



                }

            }



            @Override
            public void onFailure(Call<ClassBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(SeprateActivityForViewingFeedback.this, "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });
    }


    }

