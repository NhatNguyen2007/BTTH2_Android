package com.example.lab2_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DishAdapter extends BaseAdapter {
    Context context;
    String[] DishName;
    int[] DishImg;
    int[] Promotion;

    LayoutInflater inflater;

    public DishAdapter(Context context, String[] dishName, int[] dishImg, int[] promotion) {
        this.context = context;
        this.DishName = dishName;
        this.DishImg = dishImg;
        this.Promotion = promotion;
    }

    @Override
    public int getCount() {
        return DishName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.item_dish, null);

        ImageView imageView =(ImageView) convertView.findViewById(R.id.iv_Dish);
        TextView textView =(TextView) convertView.findViewById(R.id.tv_Dish);
        ImageView imageViewPromotion =(ImageView) convertView.findViewById(R.id.iv_Promotion);

        imageView.setImageResource(DishImg[position]);
        textView.setText(DishName[position]);
        if(Promotion[position]==1){
            imageViewPromotion.setVisibility(View.VISIBLE);
        }
        else{
            imageViewPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
