package com.example.jeremy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int CODE_TWEETS_OBTAINED = 1000;

    private ArrayList<Tweet> mTweets;
    private TweetCollection mTweetCollection;
    private static Context sContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //I used MainActivity's context in the UserCollection class to get a reference
        //to the default SharedPreferences
        sContext = getApplicationContext();

        mTweetCollection = new TweetCollection();

        // Start threaded task to retrieve Tweets
        new RetrieveTweetsTask().execute();

        //TODO : update this awkward button to a real menu
        Button settingsButton = (Button) findViewById(R.id.settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    //Once the AsyncTask completes, populate the listview with mTweets (filtered Tweets)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODE_TWEETS_OBTAINED:
                TweetAdapter adapter = new TweetAdapter(this, 0, mTweets);
                ListView tweetLV = (ListView) findViewById(R.id.listview);
                tweetLV.setAdapter(adapter);
        }
    }

    class RetrieveTweetsTask extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            //mProgressBar.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... urls) {
            try {
                mTweets = mTweetCollection.getFilteredTweets();
            } catch (Exception e) {
                Log.e("ERROR", "Error retrieving tweets: " + e.getMessage());
            }
            return "";
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
            //mProgressBar.setVisibility(View.GONE);
            //Log.i("INFO", response);

            // Use ActivityResult to notify main thread that tweets have been obtains (shouldn't update UI in ASync task)
            onActivityResult(CODE_TWEETS_OBTAINED, -1, null);
        }
    }


    //getter for UserCollection class
    public static Context getContext() {
        return sContext;
    }


}

