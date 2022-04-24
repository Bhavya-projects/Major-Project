package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 9/15/2018.
 */

public class DemoLoginForm extends Activity {
    private EditText editUserName,editPassword,editName;
    Button btnSubmit,btnCancel;
    Teacher_Page_Activity teacher_page_activity;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo_login_form);
        btnSubmit=(Button)findViewById(R.id.SubmitBtn);
        btnCancel=(Button)findViewById(R.id.CancelBtn);
        editUserName=(EditText)findViewById(R.id.EditLoginId);
        editPassword=(EditText)findViewById(R.id.EditLoginPassword);
        editName=(EditText)findViewById(R.id.EditNameId);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;
                s1=editUserName.getText().toString();
                s2=editPassword.getText().toString();
                s3=editName.getText().toString();

                //Toast.makeText(DemoLoginForm.this,s1+","+s2,Toast.LENGTH_SHORT).show();
                //sendPost(s1,s2,s3);
               if (Validators.validatename(s3))
               {
                   editName.setError("invalid name");

               }
               else if (Validators.validatepass(s2))
               {
                   editPassword.setError("password too short");

               }
               else {
                   sendPost(s1,s2,s3);

               }



            }
        });

    }
       public void sendPost(String uname,String password,String name){
        apiInterface.savepost(uname,password,name).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {



                if(response.isSuccessful()){
                    LoginBean loginBean = response.body();

                    String status = loginBean.getStatus();
                    String utype= loginBean.getUtype();
                    String name= loginBean.getName();


                    if(status.equals("success"))
                    {
                        if(utype.equals("Admin")){
                            Toast.makeText(DemoLoginForm.this,"Welcome " +name ,Toast.LENGTH_LONG).show();
                            Intent i = new Intent(DemoLoginForm.this, Admin_Page_Activity.class);
                            startActivity(i);
                        }else if (utype.equals("student")) {
                            Toast.makeText(DemoLoginForm.this,"Welcome " +name ,Toast.LENGTH_LONG).show();
                            Intent i = new Intent(DemoLoginForm.this, Student_Page_Activity.class);
                            i.putExtra("student_name",name);
                            startActivity(i);
                        } else {
                            Toast.makeText(DemoLoginForm.this,"Welcome " +name ,Toast.LENGTH_LONG).show();
                            Intent i = new Intent(DemoLoginForm.this, Teacher_Page_Activity.class);
                            i.putExtra("teacher_name",name);
                            startActivity(i);
                        }
                    }
                    else
                    {
                        Toast.makeText(DemoLoginForm.this,"Invalid Data Entered" ,Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(DemoLoginForm.this,"Login succesfull:" + status + "," +utype,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DemoLoginForm.this, "Login failed "  , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.e("Failure",t.getMessage());
                Toast.makeText(DemoLoginForm.this,"Data sending failed",Toast.LENGTH_LONG).show();

            }
        });

    }
    }

