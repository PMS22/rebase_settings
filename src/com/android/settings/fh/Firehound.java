package com.android.settings.fh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;

import org.cyanogenmod.internal.logging.CMMetricsLogger;

public class Firehound extends SettingsPreferenceFragment {

    public static final String TAG = "Firehound";

    private static final String KEY_FH_SHARE = "share";

    Preference mSourceUrl;
    Preference mGoogleUrl;
    Preference mDeveloperUrl;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.fh_info);

        mSourceUrl = findPreference("fh_source");
        mGoogleUrl = findPreference("fh_google_plus");
        mDeveloperUrl = findPreference("fh_developer");
    }

    @Override
    protected int getMetricsCategory() {
        // todo add a constant in MetricsLogger.java
        return CMMetricsLogger.MAIN_SETTINGS;
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSourceUrl) {
            launchUrl("https://github.com/firehound");
        } else if (preference == mGoogleUrl) {
            launchUrl("https://plus.google.com/communities/114615598909452601377");
        } else if (preference == mDeveloperUrl) {
            launchUrl("https://github.com/pms22");
        } else if (preference.getKey().equals(KEY_FH_SHARE)) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, String.format(
                getActivity().getString(R.string.share_message), Build.MODEL));
        startActivity(Intent.createChooser(intent, getActivity().getString(R.string.share_chooser_title)));
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(intent);
    }

}
