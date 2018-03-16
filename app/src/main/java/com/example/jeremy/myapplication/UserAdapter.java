package com.example.jeremy.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User>
{

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String user = getItem(position).getmHandle();

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_item_layout, parent, false);

        }


        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.user_checkbox);
        final TextView userTV = (TextView) convertView.findViewById(R.id.user_handle);



        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final boolean isChecked = checkBox.isChecked();
                final String userName = userTV.getText().toString();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean(userName, checkBox.isChecked());
                editor.commit();
            }
        });


        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        checkBox.setChecked(pref.getBoolean(user, true));

        userTV.setText(user);


        return convertView;

    }
}
