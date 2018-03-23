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
    public TweetAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tweet> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tweet tweet = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_list_item, parent, false);
        }


        TextView tweetContent = (TextView) convertView.findViewById(R.id.tweet_content);


        tweetContent.setText(tweet.mText);

        return convertView;

    }
}
