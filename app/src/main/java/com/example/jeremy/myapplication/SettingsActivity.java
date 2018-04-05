package com.example.jeremy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SettingsActivity extends AppCompatActivity {

    private UserCollection mUserCollection;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Add back button to action bar (implementation below in onOptionsItemSelected)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Users Following");

        //get the list of all users (hard coded into UserCollection and display it in this activity)
        mUserCollection = UserCollection.getInstance();
        ListView userLV = findViewById(R.id.settings_listview);
        UserAdapter adapter = new UserAdapter(this, R.layout.user_item_layout, mUserCollection.getAllUsers());
        userLV.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
