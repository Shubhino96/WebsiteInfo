package com.example.shubhangi.websiteinfo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private EditText url;
    String urltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button get=(Button)findViewById(R.id.getlin);
        url=(EditText)findViewById(R.id.url);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urltext= url.getText().toString();
                Log.i("lods",urltext);
                new Parser().execute();
            }
        });
    }
     private class Parser extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... params) {
            StringBuilder builder=new StringBuilder();
            Log.i("inexec",urltext);
            try {
                Document doc= Jsoup.connect(urltext).get();
                Log.i("inexec",urltext);
                Elements links = doc.select("a[href]");
                for (Element link : links) {
                    builder.append("\n").append("Link : ").append(link.attr("href"))
                            .append("\n").append("Text : ").append(link.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return builder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent i = new Intent(MainActivity.this,DisplayLink.class);
            i.putExtra("urls",s);
            startActivity(i);
        }
    }
}
