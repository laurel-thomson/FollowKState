package com.example.jeremy.myapplication;

import java.util.Date;

//This class represents a Tweet.  It models an object in the real world.

public class Tweet {

    public String mAuthor;
    public String mText;
    public Date mDate;
    public int mLikes;
    public int mRetweets;
    public int mReplies;
    public String mHandle;
    public String mImageUrl;
    public String mVideoUrl;
    public boolean mIsRetweet;
    public String mProfilePictureUrl;

    public Tweet(String author,
                 String text,
                 Date date,
                 int likes,
                 int retweets,
                 int replies,
                 String handle,
                 String imageUrl,
                 String profilePictureUrl,
                 String videoUrl,
                 boolean isRetweet) {
        this.mAuthor = author;
        this.mText = text;
        this.mDate = date;
        this.mLikes = likes;
        this.mHandle = handle;
        this.mRetweets = retweets;
        this.mIsRetweet = isRetweet;
        this.mReplies = replies;
        this.mImageUrl = imageUrl;
        this.mProfilePictureUrl = profilePictureUrl;
        this.mVideoUrl = videoUrl;
    }
}