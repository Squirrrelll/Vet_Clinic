package com.example.vetclinic.data.sources;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorageDataSource {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesStorageDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences("user_name", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void addNameSharedPreferences(String user_name) {
        editor.putString("user_name", user_name);
        editor.apply();
    }

    public String getUserName(String user_name) {
        return sharedPreferences.getString(user_name, "No name");
    }
}
