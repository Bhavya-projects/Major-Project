package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Windows-10 on 3/3/2019.
 */

public class AlertBoxForFeedback  extends Activity{
    private Button btnsave,btncancel;
    //TextView txtteachername;
    EditText editcomment;
    Spinner spinnerforrating;
    private String teachername;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_for_alert_box_activity);
        Intent i =getIntent();
        teachername = i.getStringExtra("teacher_name");


        final Dialog dialog=new Dialog(AlertBoxForFeedback.this);
        dialog.setContentView(R.layout.layout_for_alert_box_for_feedback);
        dialog.setTitle("Give Feedback");
        dialog.setCancelable(false);
        btnsave=(Button)findViewById(R.id.SaveBtn);
        btncancel=(Button) findViewById(R.id.CancelBtn);
       // txtteachername=(TextView)findViewById(R.id.txtselectedteachernameinalertbox);
        //txtteachername.setText("Ravi");

        editcomment=(EditText)findViewById(R.id.edittextforfeedback);
        spinnerforrating=(Spinner)findViewById(R.id.spinnerforrating);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(AlertBoxForFeedback.this,"you select Save",Toast.LENGTH_LONG).show();

            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(AlertBoxForFeedback.this,"you select CANCEL",Toast.LENGTH_LONG).show();

            }
        });
        dialog.show();


    }
}
