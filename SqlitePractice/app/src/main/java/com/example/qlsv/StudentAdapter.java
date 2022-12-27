package com.example.qlsv;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private final int KEY_ID_INDEX = 1;
    private final int KEY_NAME_INDEX = 2;
    LayoutInflater inflater;

    Cursor items;
    int layout;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull Cursor objects){
        inflater = LayoutInflater.from(context);
        layout = resource;
        items = objects;
    }

    public void setItems(Cursor items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.getCount();
    }

    @Override
    public Object getItem(int i) {
        return items.moveToPosition(i);
    }

    @Override
    public long getItemId(int i) {
        items.moveToPosition(i);
        return items.getInt(0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View layout_view = inflater.inflate(layout, null);
        items.moveToPosition(i);

        TextView textId = layout_view.findViewById(R.id.textId);
        TextView textName = layout_view.findViewById(R.id.textName);

        textId.setText(items.getString(KEY_ID_INDEX));
        textName.setText(items.getString(KEY_NAME_INDEX));

        return layout_view;
    }
}
