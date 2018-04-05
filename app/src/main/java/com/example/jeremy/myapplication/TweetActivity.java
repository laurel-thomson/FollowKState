package com.example.jeremy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class TweetActivity extends AppCompatActivity {

    private ImageView mProfilePic_IV;
    private ImageView mTweetPic_IV;
    private TextView mHandle_TV;
    private TextView mTweet_TV;
    private TextView mRetweets_TV;
    private TextView mLikes_TV;
    private TextView mDate_TV;
    private TweetCollection mTweetCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        // Add back button to action bar (implementation below in onOptionsItemSelected)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTweetCollection = TweetCollection.getInstance();

        Intent intent = getIntent();
        int position = intent.getIntExtra("tweetPosition",0);
        Tweet tweet = mTweetCollection.getTweet(position);
        getSupportActionBar().setTitle(tweet.mName + "'s Tweet");


        mProfilePic_IV = findViewById(R.id.iv_profilePic);
        Picasso.with(this)
                .load(tweet.mProfilePictureUrl)
                .into(mProfilePic_IV);

        mTweetPic_IV = findViewById(R.id.iv_tweetPic);
        if (!tweet.getTweetImageUrl().equals("")) {
            Picasso.with(this)
                    .load(tweet.getTweetImageUrl())
                    .into(mTweetPic_IV);
        }

        mHandle_TV = findViewById(R.id.tv_handle);
        mHandle_TV.setText(tweet.mHandle);

        mTweet_TV = findViewById(R.id.tv_tweet);
        mTweet_TV.setText(tweet.mText);

        mRetweets_TV = findViewById(R.id.tv_retweets);
        mRetweets_TV.setText("" + tweet.mRetweetCount);

        mLikes_TV = findViewById(R.id.tv_likes);
        mLikes_TV.setText("" + tweet.mLikeCount);

        mDate_TV = findViewById(R.id.tv_date);
        mDate_TV.setText(tweet.getFormattedDate());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
