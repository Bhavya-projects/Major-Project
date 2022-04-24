package com.harneet.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Windows-10 on 9/15/2018.
 */

public class DemoInitialActivity extends Activity {
    private Button loginbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo_initial);
        loginbtn=(Button)findViewById(R.id.LoginBtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemoInitialActivity.this,DemoLoginForm.class);
                startActivity(i);
            }
        });

    }
}
