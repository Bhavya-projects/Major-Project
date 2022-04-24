package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Windows-10 on 10/18/2018.
 */

public class PrintStudentList_Fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.listof_student,null);
        Toast.makeText(getActivity(),"second",Toast.LENGTH_LONG).show();


        return v;

    }

}
