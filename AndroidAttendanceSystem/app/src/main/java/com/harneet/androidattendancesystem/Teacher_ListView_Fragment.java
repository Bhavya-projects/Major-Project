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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 10/18/2018.
 */

public class Teacher_ListView_Fragment extends Fragment {
    private Spinner semester;
    private Spinner course;
    private Button sbt;
    private String item[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;
    private ApiInterface apiInterface;
    private TextView dummy, dummy1;
    private String coursenames[];
    private String teacherItem[];
    private ListView lstteacher;
    private ArrayList<String> arraytname;
    AdapterClassForPrintTeacherName adapter2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_teachers_listview, null);
        semester = (Spinner) v.findViewById(R.id.spinsemesterforlistingteacher);
        course = (Spinner) v.findViewById(R.id.spinclassforlistingteacher);
        dummy = (TextView) v.findViewById(R.id.dummy);
        dummy1 = (TextView) v.findViewById(R.id.dummy1);
        lstteacher=(ListView)v.findViewById(R.id.list);
        arraytname=new ArrayList<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getAllcoursesList().enqueue(new Callback<List<CourseNamesList>>() {
            @Override
            public void onResponse(Call<List<CourseNamesList>> call, Response<List<CourseNamesList>> response) {
                List<CourseNamesList> courseNamesLists = response.body();
                // Log.e("Size :",""+courseNamesLists.get(0).getCourse_names());
                coursenames = new String[courseNamesLists.size()];

                for (int i = 0; i < courseNamesLists.size(); i++) {
                    coursenames[i] = courseNamesLists.get(i).getCourse_name();

                }

                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, coursenames);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                course.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<CourseNamesList>> call, Throwable t) {
                Log.e("Failure", t.getMessage());


            }
        });
        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str1 = coursenames[position];
                dummy.setText(str1);
                // Log.e("str1",str1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = item[position];
                dummy1.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter);


        sbt = (Button) v.findViewById(R.id.submitforgettingteacherlist);
        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2;
                s2 = dummy.getText().toString();
                s1 = dummy1.getText().toString();
                sendclassdetails(s1,s2);

               // frag = new PrintTeacherList_Fragment();
                //loadFragment();


            }
        });

        return v;

    }

   /* public void loadFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.listingNames, frag);
        ft.commit();
    }*/

    public void sendclassdetails(String semester, String course_name) {

        apiInterface.senddataforgettingteachername(semester, course_name).enqueue(new Callback<List<GetTeacherNameBean>>() {
            @Override
            public void onResponse(Call<List<GetTeacherNameBean>> call, Response<List<GetTeacherNameBean>> response) {
                if (response.isSuccessful()) {

                    if(arraytname.size()>0){
                        arraytname = null;
                        arraytname=new ArrayList<String>();
                    }
                    List<GetTeacherNameBean> getTeacherNameBeen = response.body();
                    teacherItem = new String[getTeacherNameBeen.size()];


                    for (int i = 0; i < getTeacherNameBeen.size(); i++) {
                        teacherItem[i] = getTeacherNameBeen.get(i).getTeacher();
                        arraytname.add(getTeacherNameBeen.get(i).getTeacher());

                    }
                    adapter2 = new AdapterClassForPrintTeacherName(getActivity(), arraytname);
                    adapter2.notifyDataSetChanged();
                    lstteacher.setAdapter(adapter2);

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
