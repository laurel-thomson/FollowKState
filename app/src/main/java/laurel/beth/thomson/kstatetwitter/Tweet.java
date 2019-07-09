package laurel.beth.thomson.kstatetwitter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//This class represents a Tweet.  It models an object in the real world.

public class Tweet implements Comparable<Tweet>{

    public String mName;
    public String mHandle;
    public String mText;
    public int mRetweetCount;
    public boolean mIsRetweet;
    public int mLikeCount;
    public Date mDate;
    public String mProfilePictureUrl;
    private String mTweetImageUrl;
    private double mRank;

    public Tweet(String name, String handle, String text, int retweetCount,
                    boolean isRetweet, int likeCount,
                    Date date, String profilePicURL, String tweetImageUrl) {
        mName = name;
        mHandle = handle;
        mText = text;
        mRetweetCount = retweetCount;
        mIsRetweet = isRetweet;
        mLikeCount = likeCount;
        mDate = date;
        mProfilePictureUrl = profilePicURL;
        mTweetImageUrl = tweetImageUrl;
        setRank();
    }

    public String getFormattedDate() {
        return new SimpleDateFormat("M-d-yyyy").format(mDate) + " at " + new SimpleDateFormat("h:mm a").format(mDate);
    }

    //Gets the ranking of a Tweet based on the mDate, mLikeCount, and mRetweetCount. Max rank of 10. 10 good :)
    private void setRank(){
        Date currentTime = Calendar.getInstance().getTime();
        long diff = (currentTime.getTime() - mDate.getTime())/(1000*60*60);
        mRank = Math.min(10,(Math.log(mLikeCount+1)/Math.log(2) +
                Math.log(mRetweetCount+1)/Math.log(2) + Math.max(0,10- diff/12))/3);
    }

    @Override
    public int compareTo(Tweet tweet) {
        if (this.mRank < tweet.mRank) {
            return 1;
        }
        else if (this.mRank > tweet.mRank) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public String getTweetImageUrl() {
        return mTweetImageUrl;
    }
}