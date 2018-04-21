package com.son.jawad.ui_widgets.Activities.ProviderActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.son.jawad.tutoriallibrary.Providers.ContactProvider.Contact;
import com.son.jawad.tutoriallibrary.Providers.ContactProvider.ContactCallBackListener;
import com.son.jawad.tutoriallibrary.Providers.ContactProvider.getContacts;
import com.son.jawad.ui_widgets.Adapters.ContactAdapter;
import com.son.jawad.ui_widgets.R;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-04.
 */

public class ProviderContactActivity extends AppCompatActivity {
    public RecyclerView contactlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.providercontact_layout);
        contactlist = (RecyclerView) findViewById(R.id.contactlist);

        new getContacts(getApplicationContext()).setContactCallBackListener(new ContactCallBackListener() {
            @Override
            public void onPreexcute() {

            }

            @Override
            public void onPostexcute(List<Contact> contactsList) {
                contactlist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                contactlist.setAdapter(new ContactAdapter(contactsList));
            }
        }).fetchdata();

    }
}
