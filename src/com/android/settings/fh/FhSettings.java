package com.android.settings.fh;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.provider.SearchIndexableResource;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.Utils;

import java.util.ArrayList;
import java.util.List;

import org.cyanogenmod.internal.logging.CMMetricsLogger;

public class FhSettings extends SettingsPreferenceFragment
	implements Indexable {

private static final String TAG = FhSettings.super.getSimpleName();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.fh_settings);
	final PreferenceScreen prefScreen = getPreferenceScreen();
    }

    @Override
    protected int getMetricsCategory() {
	// todo add a constant in MetricsLogger.java
	return CMMetricsLogger.APPLICATION;
    }
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {
                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                                                                            boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();

                    SearchIndexableResource sir = new SearchIndexableResource(context);
                    sir.xmlResId = R.xml.fh_settings;
                    result.add(sir);

                    return result;
                }

                public List<String> getNonIndexableKeys(Context context) {
                    ArrayList<String> result = new ArrayList<String>();
                    return result;
                }
            };
}
