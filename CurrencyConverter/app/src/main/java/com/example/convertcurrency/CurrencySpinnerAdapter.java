package com.example.convertcurrency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CurrencySpinnerAdapter extends BaseAdapter {

    LayoutInflater inflater;
    int layout;
    List<CurrencyInfo> items;

    public CurrencySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<CurrencyInfo> objects) {
        inflater = LayoutInflater.from(context);
        layout = resource;
        items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layout, null);
        CurrencyInfo selected_item = items.get(position);

        TextView textCountry = view.findViewById(R.id.textCountry);
        TextView textName = view.findViewById(R.id.textName);

        textCountry.setText(selected_item.getCountry());
        textName.setText(selected_item.getName());

        return view;
    }
}
