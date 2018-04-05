package com.example.jeremy.myapplication;

import java.util.ArrayList;

/**
 * Created by laurel on 3/22/18.
 */

//Singleton class that stores all of the Tweets to display in the app
public class TweetCollection {

    private UserCollection mUserCollection;
    private ArrayList<Tweet> mTweets = new ArrayList<Tweet>();
    private static TweetCollection sSoleInstance;

    public static TweetCollection getInstance() {
        if (sSoleInstance == null) {
            sSoleInstance = new TweetCollection();
        }
        return sSoleInstance;
    }

    private TweetCollection() {
        mUserCollection = UserCollection.getInstance();
    }

    //returns a list of all tweets from filtered users
    public ArrayList<Tweet> getFilteredTweets() {
        ArrayList<User> filteredUsers = mUserCollection.getFilteredUsers();

        mTweets = new ArrayList<>();
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

    //Returns the tweet in the list of tweets at position
    public Tweet getTweet(int position) {
        return mTweets.get(position);
    }

    //TODO : add in method to sort the tweets by rank
}
