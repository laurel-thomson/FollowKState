package com.example.jeremy.myapplication;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by laurel on 3/22/18.
 */

//Singleton class that stores all of the K-State accounts that can be followed (hard coded)
public class UserCollection {

    private static UserCollection sSoleInstance;

    private ArrayList<User> mUsers;
    private SharedPreferences mPref;

    private UserCollection(){
        mPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.getContext());
        populateUsers();
    }

    public static UserCollection getInstance() {
        if (sSoleInstance == null) {
            sSoleInstance = new UserCollection();
        }
    return sSoleInstance;
    }

    private void populateUsers() {
        try {
            mUsers = new ArrayList<>();

            // Read in user handles from asset file, use accounts_testing for now to reduce load
            AssetManager am = MainActivity.getContext().getAssets();
            InputStream is = am.open("accounts.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {

                //lines in asset file look like:
                //kstate,K-State,T
                String[] s = line.split(",");
                mUsers.add(new User(s[0],s[1]));
                if (s[2].equals("T")) {
                    addDefaultFilter(s[0], true);
                }
                else {
                    addDefaultFilter(s[0], false);
                }
                line = br.readLine();
            }
            Collections.sort(mUsers);
        } catch (IOException exc) {
            Log.e("TAG", exc.getMessage());
        }
    }


    //returns a list of all users, ignoring visibility
    public ArrayList<User> getAllUsers() { return mUsers; }

    //returns a list of all users that have been filtered as visible by the user
    public ArrayList<User> getFilteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        for (User u : mUsers) {
            if (isFilteredUser(u)) {
                users.add(u);
            }
        }
        return users;
    }

    //returns whether or not the given user has been filtered to be visible by the user
    private boolean isFilteredUser(User user) {
        return mPref.getBoolean(user.getHandle(), true);
    }

    //Adds the default setting for the given user handle to the
    //Shared Preferences if a key in mPref for the given handle
    //has not already been created.  (Only applicable if the user
    //hasn't checked/unchecked the checkbox in SettingsActivity)
    private void addDefaultFilter(String handle, boolean isDefault) {
        if (!mPref.contains(handle)) {
            SharedPreferences.Editor editor = mPref.edit();
            editor.putBoolean(handle, isDefault);
            editor.commit();
        }
    }

}
