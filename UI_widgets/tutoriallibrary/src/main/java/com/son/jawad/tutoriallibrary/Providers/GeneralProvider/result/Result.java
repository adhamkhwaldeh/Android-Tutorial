package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.annotation.MenuRes;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.UiTweaks;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.db.DBHelper;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.AppPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.ContactsPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.PhonePojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.SearchPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.SettingsPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.ShortcutsPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.TogglesPojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher.QueryInterface;
import com.son.jawad.tutoriallibrary.R;

public abstract class Result {
    /**
     * Current information pojo
     */
    Pojo pojo = null;

    public static Result fromPojo(QueryInterface parent, Pojo pojo) {
        if (pojo instanceof AppPojo)
            return new AppResult((AppPojo) pojo);
        else if (pojo instanceof ContactsPojo)
            return new ContactsResult(parent, (ContactsPojo) pojo);
        else if (pojo instanceof SearchPojo)
            return new SearchResult((SearchPojo) pojo);
        else if (pojo instanceof SettingsPojo)
            return new SettingsResult((SettingsPojo) pojo);
        else if (pojo instanceof TogglesPojo)
            return new TogglesResult((TogglesPojo) pojo);
        else if (pojo instanceof PhonePojo)
            return new PhoneResult((PhonePojo) pojo);
        else if (pojo instanceof ShortcutsPojo)
            return new ShortcutsResult((ShortcutsPojo) pojo);


        throw new RuntimeException("Unable to create a result from POJO");
    }

    /**
     * How to display this record ?
     *
     * @param context     android context
     * @param convertView a view to be recycled
     * @return a view to display as item
     */
    public abstract View display(Context context, int position, View convertView);

    /**
     * How to display the popup menu
     *
     * @return a PopupMenu object
     */
    public PopupMenu getPopupMenu(final Context context, final RecordAdapter parent, View parentView) {
        PopupMenu menu = buildPopupMenu(context, parent, parentView);

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                return popupMenuClickHandler(context, parent, item);
            }
        });

        return menu;
    }

    /**
     * Default popup menu implementation, can be overridden by children class to display a more specific menu
     *
     * @return an inflated, listener-free PopupMenu
     */
    PopupMenu buildPopupMenu(Context context, final RecordAdapter parent, View parentView) {
        return inflatePopupMenu(R.menu.menu_item_default, context, parentView);
    }

    protected PopupMenu inflatePopupMenu(@MenuRes int menuId, Context context, View parentView) {
        PopupMenu menu = new PopupMenu(context, parentView);
        menu.getMenuInflater().inflate(menuId, menu.getMenu());

        // If app already pinned, do not display the "add to favorite" option
        // otherwise don't show the "remove favorite button"
        String favApps = PreferenceManager.getDefaultSharedPreferences(context).
                getString("favorite-apps-list", "");
        if (favApps.contains(this.pojo.id + ";")) {
            menu.getMenu().removeItem(R.id.item_favorites_add);
        } else {
            menu.getMenu().removeItem(R.id.item_favorites_remove);
        }

        return menu;
    }

    /**
     * Handler for popup menu action.
     * Default implementation only handle remove from history action.
     *
     * @return Works in the same way as onOptionsItemSelected, return true if the action has been handled, false otherwise
     */
    Boolean popupMenuClickHandler(Context context, RecordAdapter parent, MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.item_remove) {
            removeItem(context, parent);
            return true;
        } else if (i == R.id.item_favorites_add) {
            launchAddToFavorites(context, pojo);

        } else if (i == R.id.item_favorites_remove) {
            launchRemoveFromFavorites(context, pojo);

        }

        //Update Search to reflect favorite add, if the "exclude favorites" option is active
        //    ((MainActivity) context).updateRecords();

        return false;
    }

    private void launchAddToFavorites(Context context, Pojo app) {
        String msg = context.getResources().getString(R.string.toast_favorites_added);
        //  KissApplication.getDataHandler(context).addToFavorites((MainActivity) context, app.id);
        Toast.makeText(context, String.format(msg, app.name), Toast.LENGTH_SHORT).show();
    }

    private void launchRemoveFromFavorites(Context context, Pojo app) {
        String msg = context.getResources().getString(R.string.toast_favorites_removed);
        //KissApplication.getDataHandler(context).removeFromFavorites((MainActivity) context, app.id);
        Toast.makeText(context, String.format(msg, app.name), Toast.LENGTH_SHORT).show();
    }

    /**
     * Remove the current result from the list
     *
     * @param context android context
     * @param parent  adapter on which to remove the item
     */
    private void removeItem(Context context, RecordAdapter parent) {
        Toast.makeText(context, R.string.removed_item, Toast.LENGTH_SHORT).show();
        parent.removeResult(this);
    }

    public final void launch(Context context, View v) {
        Log.i("log", "Launching " + pojo.id);

        recordLaunch(context);

        // Launch
        doLaunch(context, v);
    }

    /**
     * How to launch this record ? Most probably, will fire an intent. This
     * function must call recordLaunch()
     *
     * @param context android context
     */
    protected abstract void doLaunch(Context context, View v);

    /**
     * How to launch this record "quickly" ? Most probably, same as doLaunch().
     * Override to define another behavior.
     *
     * @param context android context
     */
    public void fastLaunch(Context context, View v) {
        this.launch(context, v);
    }

    /**
     * Return the icon for this Result, or null if non existing.
     *
     * @param context android context
     */
    public Drawable getDrawable(Context context) {
        return null;
    }

    /**
     * Helper function to get a view
     *
     * @param context android context
     * @param id      id to inflate
     * @return the view specified by the id
     */
    View inflateFromId(Context context, int id) {
        LayoutInflater vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return vi.inflate(id, null);
    }

    /**
     * Enrich text for display. Put text requiring highlighting between {}
     *
     * @param text to highlight
     * @return text displayable on a textview
     */
    Spanned enrichText(String text, Context context) {
        return Html.fromHtml(text.replaceAll("\\{", "<font color=" + UiTweaks.getPrimaryColor(context) + ">").replaceAll("\\}", "</font>"));
    }

    /**
     * Put this item in application history
     *
     * @param context android context
     */
    void recordLaunch(Context context) {
        // Save in history
        KissApplication.getDataHandler(context).addToHistory(pojo.id);
    }

    public void deleteRecord(Context context) {
        DBHelper.removeFromHistory(context, pojo.id);
    }

    /*
     * Get fill color from theme
     *
     */
    public int getThemeFillColor(Context context) {
//        int[] attrs = new int[]{R.attr.resultColor /* index 0 */};
//        TypedArray ta = context.obtainStyledAttributes(attrs);
        int color = Color.WHITE;//ta.getColor(0, Color.WHITE);
        //  ta.recycle();
        return color;
    }
}
