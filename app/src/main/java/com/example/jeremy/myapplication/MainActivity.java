package com.example.jeremy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tweet  Danktweet = new Tweet("Duke Dangston", "Is the best", null, 270000, 0, 77,"@yaboi", null, null, null, false);
        Tweet fakeNews = new Tweet("CNN", "luke", null, 0, 0, 0, null, null, null, null, false);
        ArrayList<Tweet> list = new ArrayList<Tweet>();
        list.add(Danktweet);
        list.add(fakeNews);

        TweetAdapter tweetyBird = new TweetAdapter(this, 0, list);

        ListView Whateveryouwant = (ListView) findViewById(R.id.listview);

        Whateveryouwant.setAdapter(tweetyBird);
    }
}

