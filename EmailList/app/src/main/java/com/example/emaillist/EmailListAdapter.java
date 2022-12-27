package com.example.emaillist;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
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

public class EmailListAdapter extends BaseAdapter {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    int[] sender_image_colors;
    LayoutInflater inflater;
    List<EmailInfo> items;
    int layout;

    public EmailListAdapter(@NonNull Context context, int resource, @NonNull List<EmailInfo> objects){
        sender_image_colors = new int[]{
               Color.rgb(0, 255, 0), // green
               Color.rgb(255, 170, 170),
               Color.rgb(70, 233, 235),
               Color.rgb(156, 39, 176),
               Color.rgb(255, 87, 34),
                Color.rgb(139, 195, 74)
        };
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

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmailItemViewHolder holder;
        EmailInfo view_data = items.get(i);
        if(view == null) { // first time created. else -> reuse
            view = inflater.inflate(layout, null);
            holder = new EmailItemViewHolder(view);
            view.setTag(holder);
        }
        else{
            holder = (EmailItemViewHolder) view.getTag();
        }

        holder.TextViewTitle.setText(view_data.getTitle());
        holder.TextViewContent.setText(view_data.getContent());

        holder.TextViewDate.setText(dateFormat.format(view_data.getSendDate()));

        String sender = view_data.getSender();
        holder.TextViewSender.setText(sender);
        holder.TextViewImage.setText(Character.toString(sender.charAt(0)));
        holder.TextViewImage.setBackgroundTintList(ColorStateList.valueOf(sender_image_colors[i % sender_image_colors.length]));

        holder.ImageViewStar.setTag(view_data.isStar());
        holder.ImageViewStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_data.setIsStar(!(boolean) holder.ImageViewStar.getTag());
                notifyDataSetChanged();
            }
        });

        if(view_data.isStar()){
            holder.ImageViewStar.setImageResource(R.drawable.ic_solid_star_24);
        }
        else{
            holder.ImageViewStar.setImageResource(R.drawable.ic_empty_star_24);
        }

        return view;
    }
}
class EmailItemViewHolder {

    EmailItemViewHolder(View view) {
        this.TextViewImage      =  view.findViewById(R.id.textImage);
        this.TextViewTitle      =  view.findViewById(R.id.textTitle);
        this.TextViewDate       =  view.findViewById(R.id.textDate);
        this.TextViewSender     =  view.findViewById(R.id.textSender);
        this.TextViewContent    =  view.findViewById(R.id.textContent);
        this.ImageViewStar      =  view.findViewById(R.id.imageStar);
    }

    TextView TextViewImage;
    TextView TextViewTitle;
    TextView TextViewDate ;
    TextView TextViewSender;
    TextView TextViewContent;
    ImageView ImageViewStar;
}