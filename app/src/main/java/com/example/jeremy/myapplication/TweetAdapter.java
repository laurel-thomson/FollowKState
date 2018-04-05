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

    public class TweetAdapter extends ArrayAdapter<Tweet>
{

    private Context mContext;

    public TweetAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tweet> objects) {
        super(context, resource, objects);

        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tweet tweet = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_list_item, parent, false);
        }

        ImageView profilePic = convertView.findViewById(R.id.profile_pic);
        Picasso.with(mContext)
                .load(tweet.mProfilePictureUrl)
                .into(profilePic);

        TextView name = convertView.findViewById(R.id.tv_name);
        name.setText(tweet.mName);

        TextView date = convertView.findViewById(R.id.tv_date);
        date.setText(tweet.getFormattedDate());

        TextView tweetContent = convertView.findViewById(R.id.tweet_content);
        tweetContent.setText(tweet.mText);

        TextView numRetweets = convertView.findViewById(R.id.tv_retweets);
        numRetweets.setText("" + tweet.mRetweetCount);

        TextView numLikes = convertView.findViewById(R.id.tv_likes);
        numLikes.setText("" + tweet.mLikeCount);

        return convertView;

    }
}
