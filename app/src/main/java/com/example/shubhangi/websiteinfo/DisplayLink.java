package com.example.shubhangi.websiteinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DisplayLink extends AppCompatActivity {

    private String st;
    private TextView urltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_link);
        Intent intent=getIntent();
        st=intent.getStringExtra("urls");
        urltext=(TextView)findViewById(R.id.urldisp);
        urltext.setText(st);
        urltext.setMovementMethod(new ScrollingMovementMethod());
    }

}
