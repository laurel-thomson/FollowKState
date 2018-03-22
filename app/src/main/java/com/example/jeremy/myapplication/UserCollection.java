package com.example.jeremy.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by laurel on 3/22/18.
 */

public class UserCollection {

    private static UserCollection sSoleInstance;

    private HashMap<User, Boolean> mUsers = new HashMap<User, Boolean>();
    private SharedPreferences mPref;

    private UserCollection(){}

    public static UserCollection getInstance() {
        if (sSoleInstance == null) {
            sSoleInstance = new UserCollection();
            sSoleInstance.mPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.getContext());
        }
    return sSoleInstance;
    }

    //adds a user to the mUsers hashmap, adds its visibility as the value
    public void addUser(User user) {
        mUsers.put(user, mPref.getBoolean(user.getHandle(), true));
    }

    //returns a list of all users, ignoring visibility
    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        for (HashMap.Entry<User, Boolean> entry : mUsers.entrySet()) {
            User user = entry.getKey();
            userList.add(user);
        }
        return userList;
    }

    //returns a list of all users that have been filtered as visible by the user
    public ArrayList<User> getFilteredUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        for (HashMap.Entry<User, Boolean> entry : mUsers.entrySet()) {
            if (entry.getValue()) {
                userList.add(entry.getKey());
            }
        }
        return userList;
    }

    //returns whether or not the given user has been filtered to be visible by the user
    public boolean isFilteredUser(User user) {
        return mUsers.get(user);
    }

}
