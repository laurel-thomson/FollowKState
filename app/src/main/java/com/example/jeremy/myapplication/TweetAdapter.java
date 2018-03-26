package com.example.jeremy.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

//TODO : this will need to be a RecycleView
    public class TweetAdapter extends ArrayAdapter<Tweet>
{

    private Context mContext;

    //This is the Constructor.  We called it in MainActivity when we made "tweetyBird" - the adapter.
    //The third parameter is a list of Tweets...which is what we gave it to do its job!
    public TweetAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tweet> objects) {
        super(context, resource, objects);

        mContext = context;
    }

    //This is a method(function) from the ArrayAdapter class that we are overriding with
    //our own stuff.  It inflates each individual Tweet list item view.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //It loops through the list of Tweets behind the scenes and gets the Tweet from each position.
        Tweet tweet = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            //Here is where we connect the TweetAdapter to the tweet_list_item layout that Jeremy made
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_list_item, parent, false);

        }

        ImageView profilePic = convertView.findViewById(R.id.profile_pic);
        Picasso.with(mContext)
                .load(tweet.mProfilePictureUrl)
                .into(profilePic);

        TextView tweetContent = convertView.findViewById(R.id.tweet_content);
        tweetContent.setText(tweet.mText);

        TextView numRetweets = convertView.findViewById(R.id.tv_retweets);
        numRetweets.setText("" + tweet.mRetweetCount);

        TextView numLikes = convertView.findViewById(R.id.tv_likes);
        numLikes.setText("" + tweet.mLikeCount);

        // Return the completed view to render on screen
        return convertView;

    }
}
