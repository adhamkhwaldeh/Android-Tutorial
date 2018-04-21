package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.loader.LoadSettingsPojos;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.SettingsPojo;

import java.util.ArrayList;
import java.util.regex.Pattern;
import com.son.jawad.tutoriallibrary.R;

public class SettingsProvider extends Provider<SettingsPojo> {
    private String settingName;

    @Override
    public void reload() {
        this.initialize(new LoadSettingsPojos(this));

        settingName = this.getString(R.string.settings_prefix).toLowerCase();
    }

    public ArrayList<Pojo> getResults(String query) {
        ArrayList<Pojo> results = new ArrayList<>();

        int relevance;
        String settingNameLowerCased;
        for (SettingsPojo setting : pojos) {
            relevance = 0;
            settingNameLowerCased = setting.nameNormalized;
            if (settingNameLowerCased.startsWith(query))
                relevance = 10;
            else if (settingNameLowerCased.contains(" " + query))
                relevance = 5;
            else if (settingName.startsWith(query)) {
                // Also display for a search on "settings" for instance
                relevance = 4;
            }

            if (relevance > 0) {
                setting.displayName = setting.name.replaceFirst(
                        "(?i)(" + Pattern.quote(query) + ")", "{$1}");
                setting.relevance = relevance;
                results.add(setting);
            }
        }

        return results;
    }

    public Pojo findById(String id) {
        for (Pojo pojo : pojos) {
            if (pojo.id.equals(id)) {
                pojo.displayName = pojo.name;
                return pojo;
            }
        }

        return null;
    }
}
