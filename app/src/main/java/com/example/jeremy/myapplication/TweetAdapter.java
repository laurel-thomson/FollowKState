package com.example.jeremy.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

    public class TweetAdapter extends ArrayAdapter<Tweet>
{
    //This is the Constructor.  We called it in MainActivity when we made "tweetyBird" - the adapter.
    //The third parameter is a list of Tweets...which is what we gave it to do its job!
    public TweetAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tweet> objects) {
        super(context, resource, objects);
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

        //Here is where we found one of the individual layout items in tweet_list_item.
        //You can add more references here and set more of the fields with data from
        //the Tweets!
        TextView tweetContent = (TextView) convertView.findViewById(R.id.tweet_content);

        //Here is where we gave the TextView the text from the Tweet that will show
        //up in the TextView. If you added more layout items above, you'll need to set
        //their text here.
        //Don't worry about pictures yet...that will be more complicated.
        tweetContent.setText(tweet.mText);

        // Return the completed view to render on screen
        return convertView;

    }
}
