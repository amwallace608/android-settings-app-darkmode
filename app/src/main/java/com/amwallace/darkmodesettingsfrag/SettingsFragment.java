package com.amwallace.darkmodesettingsfrag;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        //associate fragment with preferences xml resource
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        //read settings value from shared preferences
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getContext().getApplicationContext());
        //get boolean of dark mode switch preference
        Boolean switchPref = sharedPreferences
                .getBoolean(SettingsActivity.KEY_PREF_DARKMODE_SWITCH, false);
        if(switchPref){
            //dark mode enabled
            Log.d("DARK MODE SETTING:", "DARK MODE ENABLED");
            //enable dark mode method, pass decorView of activity
            enableDarkMode(view);
        } else {

        }

        return view;
    }
    //enable dark mode method - change background color
    private void enableDarkMode(View decorView) {
        //set background color
        decorView.setBackgroundColor(getContext().getApplicationContext()
                .getColor(R.color.darkModeBackground));
    }

}
