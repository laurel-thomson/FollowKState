package com.example.jeremy.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ListView userLV = findViewById(R.id.settings_listview);
        ArrayList<String> users = new ArrayList<String>();
        users.add("@KState");
        users.add("@KStateRugby");
        users.add("@Dane");
        users.add("@Danes_dog");

        UserAdapter adapter = new UserAdapter(this, R.layout.user_item_layout, users);

        userLV.setAdapter(adapter);
    }
}
