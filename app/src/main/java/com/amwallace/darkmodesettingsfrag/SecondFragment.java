package com.amwallace.darkmodesettingsfrag;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

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
            //light mode enabled
            enableLightMode(view);
        }
    }

    //enable light mode method - change background color
    private void enableLightMode(View view) {
        view.setBackgroundColor(getContext().getApplicationContext()
                .getColor(R.color.lightModeBackground));
    }

    //enable dark mode method - change background color
    private void enableDarkMode(View decorView) {
        //set background color
        decorView.setBackgroundColor(getContext().getApplicationContext()
                .getColor(R.color.darkModeBackground));
    }

}
