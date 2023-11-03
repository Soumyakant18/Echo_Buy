package com.example.echobuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private pojo[] items;

    public CustomAdapter(Context context, pojo[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.demolayout_item, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.imageView3);
        TextView titleView = convertView.findViewById(R.id.textView2);
        TextView textView2 = convertView.findViewById(R.id.textView3);
        TextView textView3 = convertView.findViewById(R.id.textView4);

        pojo currentItem = items[position];
        itemImage.setImageResource(currentItem.getImageResource());
        titleView.setText(currentItem.getTitle());
        textView2.setText(currentItem.getText2());
        textView3.setText(currentItem.getText3());

        return convertView;
    }
}
