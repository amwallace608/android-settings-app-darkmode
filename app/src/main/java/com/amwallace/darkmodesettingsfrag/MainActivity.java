package com.amwallace.darkmodesettingsfrag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //save default value of setting in shared preferences
        PreferenceManager.setDefaultValues(this,R.xml.preferences, false);
        //read settings value from shared preferences
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        //get boolean of dark mode switch preference
        Boolean switchPref = sharedPreferences
                .getBoolean(SettingsActivity.KEY_PREF_DARKMODE_SWITCH, false);
        if(switchPref){
            //dark mode enabled
            Log.d("DARK MODE SETTING:", "DARK MODE ENABLED");
            //enable dark mode method, pass decorView of activity
            enableDarkMode(this.getWindow().getDecorView());
        } else {
            //light mode enabled
            enableLightMode(this.getWindow().getDecorView());
        }
    }

    //enable light mode method - change background color
    private void enableLightMode(View view) {
        view.setBackgroundColor(getColor(R.color.lightModeBackground));
    }

//enable dark mode method - change background color
    private void enableDarkMode(View decorView) {
        //set background color
        decorView.setBackgroundColor(getColor(R.color.darkModeBackground));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //launch settingsActivity
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
