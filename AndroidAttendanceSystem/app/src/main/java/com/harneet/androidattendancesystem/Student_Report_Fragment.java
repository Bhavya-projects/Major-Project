package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 10/24/2018.
 */

public class Student_Report_Fragment extends Fragment {
   // private ListView lstreport;
    private String studentnamefromstudentactivity;
    private EditText editfromdate,edittodate;
    private TextView txtvalueoftotalclasses,txtvalueofclassesattend;
    private Button sbtdetails;
    private ApiInterface apiInterface;
    Date d1,d2;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_student_report_fragment,null);
        //lstreport=(ListView)v.findViewById(R.id.listreport);
        Student_Page_Activity activity = (Student_Page_Activity) getActivity();
        editfromdate=(EditText)v.findViewById(R.id.fromdatevalue);
        edittodate=(EditText)v.findViewById(R.id.todatevalue);
        txtvalueoftotalclasses=(TextView)v.findViewById(R.id.txtvalueoftotalclasses);
        txtvalueofclassesattend=(TextView)v.findViewById(R.id.txtvalueofclassesattend);
        sbtdetails=(Button)v.findViewById(R.id.sbtfromdatetodate);
        studentnamefromstudentactivity = activity.getMyData();
        apiInterface=ApiClient.getClient().create(ApiInterface.class);


        sbtdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;

                s1=editfromdate.getText().toString();
                s2=edittodate.getText().toString();
                s3=studentnamefromstudentactivity;
                /*Date s1,s2;
                s1=editfromdate.getText();
                s2=edittodate.getText();*/
                /*SimpleDateFormat format=new SimpleDateFormat("yyyy-MM--dd");

                try {
                     d1=format.parse(s1);
                     d2=format.parse(s2);



                }
                catch (ParseException e){
                    e.printStackTrace();

                }*/

                //Toast.makeText(DemoLoginForm.this,s1+","+s2,Toast.LENGTH_SHORT).show();

                sendPost(s1,s2,s3);
            }
        });
        return v;

    }
    public void sendPost(String fromdate, String todate,String s_name) {

        apiInterface.savepostforprintingattendance(fromdate,todate,s_name).enqueue(new Callback<ResultOfAttendanceBean>() {
            @Override
            public void onResponse(Call<ResultOfAttendanceBean> call, Response<ResultOfAttendanceBean> response) {
                if (response.isSuccessful())
                {
                    ResultOfAttendanceBean resultOfAttendanceBean = response.body();

                    String totalclassvalue = resultOfAttendanceBean.getTotal_classes();
                    String classesattendvalue = resultOfAttendanceBean.getAttend_classes();
                   // Integer int1= Integer.parseInt(totalclassvalue);
                    //Integer int2= Integer.parseInt(classesattendvalue);
                   // Float intpercent=(int2/int1)*100;
                    Float int1=Float.parseFloat(totalclassvalue);
                    Float int2=Float.parseFloat(classesattendvalue);


                    Float percent= int2/int1 *100;

                    txtvalueoftotalclasses.setText("Name-- "+studentnamefromstudentactivity+"     Total Classes -- "+totalclassvalue);
                    txtvalueofclassesattend.setText("       Classes Attend -- "+classesattendvalue+"      Percentages -- "+percent);
                }



            }


            @Override
            public void onFailure(Call<ResultOfAttendanceBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });

    }

    }

