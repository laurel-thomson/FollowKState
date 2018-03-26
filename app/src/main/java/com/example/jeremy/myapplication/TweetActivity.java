package com.example.jeremy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TweetActivity extends AppCompatActivity {

    private ImageView mProfilePic_IV;
    private TextView mHandle_TV;
    private TextView mTweet_TV;
    private TextView mRetweets_TV;
    private TextView mLikes_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        // Add back button to action bar (implementation below in onOptionsItemSelected)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Dummy Tweet data for now
        Tweet t = new Tweet("Josh Brummer", "i_am_not_a_bird", "THIS IS A BIG FAT TEST", 42, false, 69, null, "http://pbs.twimg.com/profile_images/876811392384356352/FOCr1pfY_normal.jpg");

        mProfilePic_IV = findViewById(R.id.iv_profilePic);
        Picasso.with(this)
                .load(t.mProfilePictureUrl)
                .into(mProfilePic_IV);

        mHandle_TV = findViewById(R.id.tv_handle);
        mHandle_TV.setText(t.mHandle);

        mTweet_TV = findViewById(R.id.tv_tweet);
        mTweet_TV.setText(t.mText);

        mRetweets_TV = findViewById(R.id.tv_retweets);
        mRetweets_TV.setText("" + t.mRetweetCount);

        mLikes_TV = findViewById(R.id.tv_likes);
        mLikes_TV.setText("" + t.mLikeCount);
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
