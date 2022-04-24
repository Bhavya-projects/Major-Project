package com.harneet.androidattendancesystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Windows-10 on 10/20/2018.
 */

public class AdapterClassForPrintStudentName extends BaseAdapter {
    Context ctxg;
    ArrayList<String> arraysnameg;
    LayoutInflater layoutInflater;
    public AdapterClassForPrintStudentName(Context ctx, ArrayList<String> arraysname)
    {   ctxg=ctx;
        arraysnameg=arraysname;

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
            v= layoutInflater.inflate(R.layout.design_for_printing_student_name,null);
        }
        TextView txttname=(TextView)v.findViewById(R.id.txtstudent);

        txttname.setText(arraysnameg.get(position));

        txttname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctxg,"you select"+arraysnameg.get(position),Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
    }

