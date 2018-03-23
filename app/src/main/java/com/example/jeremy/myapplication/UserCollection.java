package com.example.jeremy.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by laurel on 3/22/18.
 */

//Singleton class that stores all of the K-State accounts that can be followed (hard coded)
public class UserCollection {

    private static UserCollection sSoleInstance;

    //TODO : hardcode all users in here :D
    private User[] mUsers = {new User("kstate"), new User("KStateMBB")};
    private SharedPreferences mPref;

    private UserCollection(){}

    public static UserCollection getInstance() {
        if (sSoleInstance == null) {
            sSoleInstance = new UserCollection();
            sSoleInstance.mPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.getContext());
        }
    return sSoleInstance;
    }


    //returns a list of all users, ignoring visibility
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < mUsers.length; i++) {
            users.add(mUsers[i]);
        }
        return users;
    }

    //returns a list of all users that have been filtered as visible by the user
    public ArrayList<User> getFilteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < mUsers.length; i++) {
            if (isFilteredUser(mUsers[i])) {
                users.add(mUsers[i]);
            }
        }
        return users;
    }

    //returns whether or not the given user has been filtered to be visible by the user
    public boolean isFilteredUser(User user) {
        return mPref.getBoolean(user.getHandle(), true);
    }

}
