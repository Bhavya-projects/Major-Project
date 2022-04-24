package com.harneet.androidattendancesystem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class AdapterClassWithRadioButton extends BaseAdapter {
    Context ctxg;
    ArrayList<String> arraysnameg;
    LayoutInflater layoutInflater;
    private ApiInterface mApiInterface;
    private ArrayList<String> status= new ArrayList<>();

    public AdapterClassWithRadioButton(Context ctx, ArrayList<String> arraysname, ApiInterface apiInterface,String tname,String sem,String branch)
    {   ctxg=ctx;
        arraysnameg=arraysname;
        mApiInterface = apiInterface;
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return arraysnameg.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v;
        v=convertView;
        if (v==null)
        {
            v= layoutInflater.inflate(R.layout.designof_student_list_with_radiobutton,null);
        }
        TextView txtsname=(TextView)v.findViewById(R.id.txtstudentnamesfortakingattendance);
        RadioButton radioPresent = (RadioButton)v.findViewById(R.id.radioPresent);
        RadioButton radioAbsent = (RadioButton)v.findViewById(R.id.radioAbsent);
        final RadioGroup radiostatus = (RadioGroup) v.findViewById(R.id.radioAttendance);

        txtsname.setText(arraysnameg.get(position));

        radiostatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId= radiostatus.getCheckedRadioButtonId();
                RadioButton radio = (RadioButton)v.findViewById(selectedId);
                status.add(radio.getText().toString());

            }
        });


        txtsname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctxg,"you select"+arraysnameg.get(position),Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

   public void sendDataToDatabase() {
        mApiInterface.saveStudentStatus(arraysnameg,status,"tname","sem","branch").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String val = response.body();

                if(val.equals("Success")){
                    Toast.makeText(ctxg,"succesfully inserted",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ctxg,"insertion failed",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(ctxg,"data sending failed",Toast.LENGTH_LONG).show();


            }
        });
    }
}

