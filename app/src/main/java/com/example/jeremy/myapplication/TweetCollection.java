package com.example.jeremy.myapplication;

import java.util.ArrayList;

/**
 * Created by laurel on 3/22/18.
 */

//holds all the tweets from the filtered users.  The number of tweets to get per user
//is hardcoded into the TwitterClient class
public class TweetCollection {

    private UserCollection mUserCollection;
    private ArrayList<Tweet> mTweets = new ArrayList<Tweet>();

    public TweetCollection() {
        mUserCollection = UserCollection.getInstance();
    }

    //returns a list of all tweets from filtered users
    public ArrayList<Tweet> getFilteredTweets() {
        ArrayList<User> filteredUsers = mUserCollection.getFilteredUsers();
        for (int i = 0; i < filteredUsers.size(); i++) {
            ArrayList<Tweet> tweets = TwitterClient.getTweets(filteredUsers.get(i).getHandle());
            if (tweets != null) {
                for (int j = 0; j < tweets.size(); j++) {
                    mTweets.add(tweets.get(j));
                }
            }
        }
        return mTweets;
    }
}
