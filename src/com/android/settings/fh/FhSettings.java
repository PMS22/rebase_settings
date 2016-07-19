package com.android.settings.fh;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import java.util.List;

import org.cyanogenmod.internal.logging.CMMetricsLogger;

public class FhSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.fh_settings);
    }

    protected int getMetricsCategory()
    {
	return CMMetricsLogger.APPLICATION;
    }
}
