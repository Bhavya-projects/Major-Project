package com.harneet.androidattendancesystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Windows-10 on 3/2/2019.
 */

public class AdapterClassForGivingFeedbackToTeacher extends BaseAdapter {
    Context ctxg;
    ArrayList<String> arraytnameg;
    LayoutInflater layoutInflater;
   // AlertBoxForFeedback alertBoxForFeedback;
    public String teachername;

    public AdapterClassForGivingFeedbackToTeacher(Context ctx, ArrayList<String> arraytname) {
        ctxg = ctx;
        arraytnameg = arraytname;

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arraytnameg.size();
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
        v = convertView;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.design_for_printing_teacher_name_for_feedback, null);
        }
        final TextView txttname = (TextView) v.findViewById(R.id.txtteachername);

        txttname.setText(arraytnameg.get(position));
        teachername=txttname.getText().toString();



        txttname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ctxg, "you select " + arraytnameg.get(position), Toast.LENGTH_LONG).show();
               // alertBoxForFeedback=new AlertBoxForFeedback();
                /*Intent i=new Intent(ctxg,AlertBoxForFeedback.class);
                Intent i1=new Intent();
                i1.putExtra("teacher_name",teachername);

                ctxg.startActivity(i);*/


            }
        });

        return v;
    }
}
