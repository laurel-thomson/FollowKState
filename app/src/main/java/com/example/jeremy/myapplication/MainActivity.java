package com.example.jeremy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tweet  Danktweet = new Tweet("Duke Dangston", "Is the best", null, 270000, 0, 77,"@yaboi", null, null, null, false);

        ListView Whateveryouwant = (ListView) findViewById(R.id.listview);
    }
}

