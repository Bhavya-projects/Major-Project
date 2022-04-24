package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Windows-10 on 10/18/2018.
 */

public class ViewDetails_Fragment extends Fragment {
    private Button btnviewTeacher,btnviewStudent;
    private Fragment frag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_viewdetails_fragment,null);
        btnviewTeacher=(Button)v.findViewById(R.id.ViewTeachers);
        btnviewStudent=(Button)v.findViewById(R.id.ViewStudents);
        btnviewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new Teacher_ListView_Fragment();
                loadFragment();

            }
        });

        btnviewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new Student_ListView_Fragment();
                loadFragment();

            }
        });

        return v;

    }
    public void loadFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.listingNames, frag);
        ft.commit();
    }
}
