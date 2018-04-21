package com.son.jawad.ui_widgets.Activities.StorageActivities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.son.jawad.ui_widgets.DataBase.Contact;
import com.son.jawad.ui_widgets.DataBase.DatabaseHandler;
import com.son.jawad.ui_widgets.R;

import java.util.List;


public class AndroidSQLiteTutorialActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    TextView datatext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqllite_layout);
        datatext = (TextView) findViewById(R.id.datatext);
        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = datatext.getText().toString() + "\n" +
                    "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            // Log.d("Name: ", log);
            datatext.setText(log);
        }
    }
}