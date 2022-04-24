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
 * Created by Windows-10 on 3/30/2019.
 */

public class AdapterClassForPrintAllTeacherName extends BaseAdapter {
    Context ctxg;
    ArrayList<String> arraytnameg;
    LayoutInflater layoutInflater;
    String name;
    public AdapterClassForPrintAllTeacherName(Context ctx, ArrayList<String> arraytname) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        v = convertView;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.design_for_printing_all_teacher_name, null);
        }
        final TextView txttname = (TextView) v.findViewById(R.id.txtallteacher);
        Integer integer=getCount();

        txttname.setText(arraytnameg.get(position));

        //name= (String) txttname.getText();

        txttname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name= (String)txttname.getText();



                /*FeedbackBean feedbackBean = new FeedbackBean();
                feedbackBean.setTnanme("ABC");
                feedbackBean.setRating("4");
                feedbackBean.setComment("fdfgffgg");

                feedbackBeanArrayList.add(feedbackBean); // Size = 1
                //Server save code
                feedbackBeanArrayList.clear();*/
                //alertBoxForFeedback=new AlertBoxForFeedback();
                //Intent i=new Intent(ctxg,AlertBoxForFeedback.class);
                //sctxg.startActivity(i);
                Intent i=new Intent(ctxg,SeprateActivityForViewingFeedback.class);
                i.putExtra("teacher_name",name);

                ctxg.startActivity(i);




            }
        });
        return v;
    }
}
