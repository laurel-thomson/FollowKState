package com.example.jeremy.myapplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public String getFormattedDate() {
        return new SimpleDateFormat("M-d-yyyy").format(mDate) + " at " + new SimpleDateFormat("h:mm a").format(mDate);
    }

    //Gets the ranking of a Tweet based on the mDate, mLikeCount, and mRetweetCount. Max rank of 10. 10 good :)
    public double getRank(){
        double rank;
        Date currentTime = Calendar.getInstance().getTime();
        long diff = (currentTime.getTime() - mDate.getTime())/(1000*60*60);
        rank = Math.min(10,(Math.log(mLikeCount+1)/Math.log(2) + Math.log(mRetweetCount+1)/Math.log(2) + Math.max(0,10- diff/12))/3);
        return rank;

    }

}