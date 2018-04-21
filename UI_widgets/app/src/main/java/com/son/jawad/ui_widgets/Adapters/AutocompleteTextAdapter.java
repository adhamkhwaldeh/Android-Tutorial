package com.son.jawad.ui_widgets.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.son.jawad.ui_widgets.Models.AutoCompleteModel;
import com.son.jawad.ui_widgets.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adhamkh on 2017-08-17.
 */

public class AutocompleteTextAdapter extends BaseAdapter implements Filterable {
    public List<AutoCompleteModel> autoCompleteModelList, SearchList;
    public Context context;
    public LayoutInflater layoutInflater;

    public AutocompleteTextAdapter(Context context, List<AutoCompleteModel> autoCompleteModelList) {
        this.context = context;
        this.autoCompleteModelList = autoCompleteModelList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return autoCompleteModelList == null ? 0 : autoCompleteModelList.size();
    }

    @Override
    public AutoCompleteModel getItem(int position) {
        return autoCompleteModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.autocomplete_item, null, false);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.text1);
        nameTextView.setText(autoCompleteModelList.get(position).getName());

        return convertView;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                final FilterResults oReturn = new FilterResults();
                final List<AutoCompleteModel> results = new ArrayList<>();
                if (SearchList == null) {
                    SearchList = autoCompleteModelList;
                }
                if (charSequence != null) {
                    if (SearchList != null && SearchList.size() > 0) {
                        for (final AutoCompleteModel autoCompleteModel : SearchList) {
                            if (autoCompleteModel.getName().toLowerCase().contains(charSequence.toString())) {
                                results.add(autoCompleteModel);
                            }
                        }
                    }
                    oReturn.values = results;
                    oReturn.count = results.size();
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                try {
                    autoCompleteModelList = (ArrayList<AutoCompleteModel>) filterResults.values;
                    notifyDataSetChanged();
                } catch (Exception ex) {
                }
            }

        };
    }

}
