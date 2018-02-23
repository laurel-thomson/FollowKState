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

        //this is where we made some Tweets: make some more and trying changing the other parameters!
        Tweet  Danktweet = new Tweet("Duke Dangston", "Is the best", null, 270000, 0, 77,"@yaboi", null, null, null, false);
        Tweet fakeNews = new Tweet("CNN", "luke", null, 0, 0, 0, null, null, null, null, false);

        //this is where we bundled up the Tweets into a nice list
        ArrayList<Tweet> list = new ArrayList<Tweet>();

        //this is where we added the Tweets to the list
        list.add(Danktweet);
        list.add(fakeNews);

        //this is where we make an instance of TweetAdapter named "tweetyBird".  We give is the list
        //of Tweets.
        TweetAdapter tweetyBird = new TweetAdapter(this, 0, list);

        //Find the ListView that we made in the activity_main layout file and give it a name
        ListView Whateveryouwant = (ListView) findViewById(R.id.listview);

        //Connect the ListView with the TweetAdapter
        Whateveryouwant.setAdapter(tweetyBird);
    }
}

