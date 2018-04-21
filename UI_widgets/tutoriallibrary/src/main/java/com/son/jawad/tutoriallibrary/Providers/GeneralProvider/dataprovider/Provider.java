package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.LoadingTag;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.loader.LoadPojos;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;


public abstract class Provider<T extends Pojo> extends Service implements IProvider {
    /**
     * Storage for search items used by this provider
     */
    protected List<T> pojos = new ArrayList<>();
    private boolean loaded = false;

    /**
     * Scheme used to build ids for the pojos created by this provider
     */
    private String pojoScheme = "(none)://";

    /**
     * Binder given to clients
     */
    private final IBinder binder = new LocalBinder();


    /**
     * (Re-)load the providers resources when the provider has been completely initialized
     * by the Android system
     */
    @Override
    public void onCreate() {
        super.onCreate();

        this.reload();
    }


    protected void initialize(LoadPojos<T> loader) {
        Log.i("Provider.initialize", "Starting provider: " + this.getClass().getSimpleName());

        loader.setProvider(this);
        this.pojoScheme = loader.getPojoScheme();
        loader.execute();
    }

    /**
     * Synchronously retrieve list of search results for the given query string
     *
     * @param s Some string query (usually provided by an user)
     */
    public abstract ArrayList<Pojo> getResults(String s);

    public abstract void reload();

    public boolean isLoaded() {
        return this.loaded;
    }

    public void loadOver(ArrayList<T> results) {
        Log.i("Provider.loadOver", "Done loading provider: " + this.getClass().getSimpleName());

        // Store results
        this.pojos = results;
        this.loaded = true;

        // Broadcast this event
        Intent i = new Intent(LoadingTag.LOAD_OVER);
        this.sendBroadcast(i);
    }

    /**
     * Tells whether or not this provider may be able to find the pojo with
     * specified id
     *
     * @param id id we're looking for
     * @return true if the provider can handle the query ; does not guarantee it
     * will!
     */
    public boolean mayFindById(String id) {
        return id.startsWith(pojoScheme);
    }

    /**
     * Try to find a record by its id
     *
     * @param id id we're looking for
     * @return null if not found
     */
    public Pojo findById(String id) {
        return null;
    }


    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        public IProvider getService() {
            // Return this instance of the provider so that clients can call public methods
            return Provider.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
}
