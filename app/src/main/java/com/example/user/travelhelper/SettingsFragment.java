package com.example.user.travelhelper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.widget.Toast;

/**
 * Created by User on 3/18/2017.
 */

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);


    }
    @Override
    public void onResume() {
        super.onResume();

        getPreferenceManager().getSharedPreferences()
        .unregisterOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("check_box_preference_1")) {
            Toast.makeText(getActivity(), "", Toast.LENGTH_LONG).show();
        }

    }
}
