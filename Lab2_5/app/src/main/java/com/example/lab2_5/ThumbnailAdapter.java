package com.example.lab2_5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;

    public ThumbnailAdapter(Activity context, int layoutID, List<Thumbnail> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_thumbnail, parent, false);

        TextView tvSelectedThumbnail = (TextView) convertView.findViewById(R.id.item_selected_thumbnail_tv);

        Thumbnail thumbnail = this.getItem(position);
        if(thumbnail != null){
            tvSelectedThumbnail.setText(thumbnail.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thumbnail, parent, false);

        TextView tvThumbnail = (TextView) convertView.findViewById(R.id.item_thumbnail_tv);
        ImageView ivThumbnail = (ImageView) convertView.findViewById(R.id.item_thumbnail_iv);

        Thumbnail thumbnail = this.getItem(position);
        if(thumbnail != null){
            tvThumbnail.setText(thumbnail.getName());
            ivThumbnail.setImageResource(thumbnail.getImg());
        }
        return convertView;
    }

}
