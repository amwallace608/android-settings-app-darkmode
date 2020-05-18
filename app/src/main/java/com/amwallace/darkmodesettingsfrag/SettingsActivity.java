package com.amwallace.darkmodesettingsfrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    public static final String KEY_PREF_DARKMODE_SWITCH = "dark_mode_switch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //display settings fragment as main content of activity
        //supportFragmentManager - class extends AppCompatActivity
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
