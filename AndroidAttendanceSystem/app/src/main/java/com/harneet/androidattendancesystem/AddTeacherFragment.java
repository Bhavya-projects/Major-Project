package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 9/17/2018.
 */

public class AddTeacherFragment extends Fragment {
    private EditText teacher_name, teacher_user_name, teacher_password, teacher_mno, teacher_email, teacher_hq;
    private Button submit_teacher_details;
    private TextView txt1,txt2,txt3;
    private ApiInterface apiInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_add_teacher_fragment, null);
        teacher_name = (EditText) v.findViewById(R.id.EditTeacherName);
        teacher_user_name = (EditText) v.findViewById(R.id.EditTeacherUserName);
        teacher_password = (EditText) v.findViewById(R.id.EditTeacherPassword);
        teacher_mno = (EditText) v.findViewById(R.id.EditTeacherMobileNo);
        teacher_email = (EditText) v.findViewById(R.id.EditTeacherEmailId);
        teacher_hq = (EditText) v.findViewById(R.id.EditTeacherHighestQualification);


        submit_teacher_details = (Button) v.findViewById(R.id.SubmitAddTeacher);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        submit_teacher_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1, s2, s3, s4, s5, s6;
                s1 = teacher_name.getText().toString();
                s2 = teacher_user_name.getText().toString();
                s3 = teacher_password.getText().toString();
                s4 = teacher_mno.getText().toString();
                s5 = teacher_email.getText().toString();
                s6 = teacher_hq.getText().toString();
                if (Validators.validatename(s1))
                {
                    teacher_name.setError("invalid name");

                }
                else if (Validators.validatepass(s3))
                {
                    teacher_password.setError("password too short");

                }
                else if (Validators.validatephno(s4))
                {
                    teacher_mno.setError("invalid phone number");

                }
                else if (Validators.validateemail(s5))
                {
                    teacher_email.setError("invalid email");

                }
                else {
                    sendteacherdetails(s1, s2, s3, s4, s5, s6);

                }


            }
        });


        return v;

    }

    public void sendteacherdetails(String tname, String tuname, String tpassword, String tmno, String temail, String thq) {

        apiInterface.saveteacherdetails(tname, tuname, tpassword, tmno, temail, thq).enqueue(new Callback<TeacherBean>() {
            @Override
            public void onResponse(Call<TeacherBean> call, Response<TeacherBean> response) {
                if (response.isSuccessful()) {
                    TeacherBean teacherBean = response.body();
                    String status = teacherBean.getStatus();
                    if (status.equals("success")) {
                        Toast.makeText(getActivity(), "Succesfully inserted", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity(), "Insertion failed", Toast.LENGTH_LONG).show();

                    }

                }

            }

            @Override
            public void onFailure(Call<TeacherBean> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });

    }
    private boolean validatenameunamepass(){
        String str1, str2, str3,str4;
        str1 = teacher_name.getText().toString();
        str2 = teacher_user_name.getText().toString();
        str3 = teacher_password.getText().toString();
        str4 = teacher_email.getText().toString();


        if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty() ){
            txt1.setError("Field can't be empty");
            txt2.setError("Field can't be empty");
            txt3.setError("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(str4).matches())
        {
            teacher_email.setError("Enter Valid Email");
            return false;

        }else{
            teacher_email.setError(null);
            return true;

        }


    }


}

