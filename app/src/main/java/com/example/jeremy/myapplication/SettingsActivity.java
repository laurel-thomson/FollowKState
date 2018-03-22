package com.example.jeremy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class SettingsActivity extends Activity {

    private final int CODE_USERS_OBTAINED = 1001;
    private UserCollection mUserCollection;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //new RetrieveUsersTask().execute();
        mUserCollection = UserCollection.getInstance();
        mUserCollection.addUser(new User("kstate"));

        ListView userLV = findViewById(R.id.settings_listview);
        UserAdapter adapter = new UserAdapter(this, R.layout.user_item_layout, mUserCollection.getAllUsers());
        userLV.setAdapter(adapter);

    }

/*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case CODE_USERS_OBTAINED:
                    ListView userLV = findViewById(R.id.settings_listview);
                    UserAdapter adapter = new UserAdapter(this, R.layout.user_item_layout, mUsers);
                    userLV.setAdapter(adapter);
            }
        }

        class RetrieveUsersTask extends AsyncTask<String, Void, String> {

            protected void onPreExecute() {
                //mProgressBar.setVisibility(View.VISIBLE);
            }

            protected String doInBackground(String... urls) {
                try {
                    TwitterClient.getUsers();
                    UserCollection userList = UserCollection.getInstance();
                    mUsers = userList.getAllUsers();
                } catch (Exception e) {
                    Log.e("ERROR", "Error retrieving users: " + e.getMessage());
                }
                return "";
            }

            protected void onPostExecute(String response) {
                if(response == null) {
                    response = "THERE WAS AN ERROR";
                }
                //mProgressBar.setVisibility(View.GONE);
                //Log.i("INFO", response);

                // Use ActivityResult to notify main thread that tweets have been obtains (shouldn't update UI in ASync task)
                onActivityResult(CODE_USERS_OBTAINED, -1, null);
            }
        }
        */
}
