package com.harneet.androidattendancesystem;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows-10 on 3/30/2019.
 */

public class View_Feedback_Fragment extends Fragment {
    private ListView lstteachernamesforviewfeedback;
    private ApiInterface apiInterface;
    private ArrayList<String> arraytname;
    AdapterClassForPrintAllTeacherName adapter2;
    private String teacherItem[];
    private Button button;
    String value="1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layoutforprintteachername, null);
        lstteachernamesforviewfeedback = (ListView) v.findViewById(R.id.listofteachersforviewfeedback);
        button=(Button)v.findViewById(R.id.printallteachernamesforgivingfeedback);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        arraytname = new ArrayList<>();

       // printallteachernames();
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          apiInterface.fetchingallteachersforfeedback(value).enqueue(new Callback<List<GetAllTeacherNameForViewFeedback>>() {
                                              @Override
                                              public void onResponse(Call<List<GetAllTeacherNameForViewFeedback>> call, Response<List<GetAllTeacherNameForViewFeedback>> response) {
                                                  if (response.isSuccessful()) {

                                                      if (arraytname.size() > 0) {
                                                          arraytname = null;
                                                          arraytname = new ArrayList<String>();
                                                      }
                                                      List<GetAllTeacherNameForViewFeedback> getTeacherNameBeen1 = response.body();
                                                      teacherItem = new String[getTeacherNameBeen1.size()];


                                                      for (int i = 0; i < getTeacherNameBeen1.size(); i++) {
                                                          //teacherItem[i] = getTeacherNameBeen.get(i).getTeacher_name();
                                                          teacherItem[i] = getTeacherNameBeen1.get(i).getTeacher_name();

                                                          arraytname.add(getTeacherNameBeen1.get(i).getTeacher_name());

                                                      }
                                                      adapter2 = new AdapterClassForPrintAllTeacherName(getActivity(), arraytname);
                                                      adapter2.notifyDataSetChanged();
                                                      lstteachernamesforviewfeedback.setAdapter(adapter2);

                                                  }


                                              }


                                              @Override
                                              public void onFailure(Call<List<GetAllTeacherNameForViewFeedback>> call, Throwable t) {
                                                  Log.e("Failure", t.getMessage());
                                                  Toast.makeText(getActivity(), "Data sending failed", Toast.LENGTH_LONG).show();

                                              }
                                          });

                                      }
                                  }
        );


        return v;
    }


}


