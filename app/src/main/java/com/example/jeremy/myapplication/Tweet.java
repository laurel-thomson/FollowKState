package com.example.jeremy.myapplication;

import java.util.Date;

//This class represents a Tweet.  It models an object in the real world.

public class Tweet {
    public String mName;
    public String mHandle;
    public String mText;
    public int mRetweetCount;
    public boolean mIsRetweet;
    public int mLikeCount;
    public Date mDate;
    public String mProfilePictureUrl;

    public Tweet(String name, String handle, String text, int retweetCount,
                    boolean isRetweet, int likeCount, Date date, String profilePicURL) {
        mName = name;
        mHandle = handle;
        mText = text;
        mRetweetCount = retweetCount;
        mIsRetweet = isRetweet;
        mLikeCount = likeCount;
        mDate = date;
        mProfilePictureUrl = profilePicURL;
    }

}