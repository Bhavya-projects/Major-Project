package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 10/18/2018.
 */

public class PrintTeacherList_Fragment extends Fragment {
    //private String sem, course;
    ApiInterface apiInterface;
    private String teacherItem[];
    private ListView lstteacher;
    private ArrayList<String> arraytname;
    AdapterClassForPrintTeacherName adapter;


   /* PrintTeacherList_Fragment(String s1,String s2)
    {
       this.sem=s1;
        this.course=s2;
    }*/

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listof_teacher, null);
        lstteacher=(ListView)v.findViewById(R.id.printteachername);
        arraytname=new ArrayList<>();
       // Toast.makeText(getActivity(), "first", Toast.LENGTH_LONG).show();


        return v;

    }

    public void sendclassdetails(String semester, String course_name) {

        apiInterface.senddataforgettingteachername(semester,course_name).enqueue(new Callback<List<GetTeacherNameBean>>() {
            @Override
            public void onResponse(Call<List<GetTeacherNameBean>> call, Response<List<GetTeacherNameBean>> response) {
                if (response.isSuccessful()) {
                    List<GetTeacherNameBean> getTeacherNameBeen = response.body();
                    teacherItem = new String[getTeacherNameBeen.size()];


                    for(int i=0;i<getTeacherNameBeen.size();i++){
                        teacherItem[i]= getTeacherNameBeen.get(i).getTeacher();
                        arraytname.add(getTeacherNameBeen.get(i).getTeacher());

                    }
                    adapter=new AdapterClassForPrintTeacherName(getActivity(),arraytname);
                    lstteacher.setAdapter(adapter);



                }

            }


            @Override
            public void onFailure(Call<List<GetTeacherNameBean>> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

            }
        });


    }
}
