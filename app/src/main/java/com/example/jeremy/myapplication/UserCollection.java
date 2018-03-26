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

/**
 * Created by laurel on 3/22/18.
 */

//Singleton class that stores all of the K-State accounts that can be followed (hard coded)
public class UserCollection {

    private static UserCollection sSoleInstance;

    //TODO : hardcode all users in here :D
    private ArrayList<User> mUsers;
    //private User[] mUsers = {new User("kstate"), new User("KStateMBB")};
    private SharedPreferences mPref;

    private UserCollection(){ populateUsers(); }

    public static UserCollection getInstance() {
        if (sSoleInstance == null) {
            sSoleInstance = new UserCollection();
            sSoleInstance.mPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.getContext());
        }
    return sSoleInstance;
    }

    private void populateUsers() {
        try {
            mUsers = new ArrayList<>();

            // Read in user handles from asset file, use accounts_testing for now to reduce load
            AssetManager am = MainActivity.getContext().getAssets();
            InputStream is = am.open("accounts_testing.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                mUsers.add(new User(line));
                line = br.readLine();
            }
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
    public boolean isFilteredUser(User user) {
        return mPref.getBoolean(user.getHandle(), true);
    }

}
