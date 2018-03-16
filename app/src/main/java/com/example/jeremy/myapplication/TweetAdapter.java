package com.example.jeremy.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TweetAdapter extends ArrayAdapter<Tweet> {

    public TweetAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tweet> objects) {
        super(context, resource, objects);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position

        Tweet tweet = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_list_item, parent, false);

        }

        // Lookup view for data population

        TextView tweetContent = (TextView) convertView.findViewById(R.id.tweet_content);

        // Populate the data into the template view using the data object

        tweetContent.setText(tweet.mText);

        // Return the completed view to render on screen

        return convertView;

    }
}
