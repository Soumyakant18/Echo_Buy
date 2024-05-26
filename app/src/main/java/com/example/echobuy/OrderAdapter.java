package com.example.echobuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends BaseAdapter {

    private List<Order> orderList;
    private LayoutInflater inflater;

    public OrderAdapter(Context context, List<Order> orders) {
        this.orderList = orders;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.demolayout_item, parent, false); // Replace with your item layout
            holder = new ViewHolder();


            holder.textViewName = convertView.findViewById(R.id.textView2); // Replace with your TextView IDs
            holder.textViewDescription = convertView.findViewById(R.id.textView3);
            holder.textViewPrice = convertView.findViewById(R.id.textView4);
            holder.imageView = convertView.findViewById(R.id.imageView3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Order currentOrder = orderList.get(position);

        // Set data to your TextViews
        holder.textViewName.setText(currentOrder.getName());
        holder.textViewDescription.setText(currentOrder.getDescription());
        holder.textViewPrice.setText(currentOrder.getPrice());

        return convertView;
    }

    static class ViewHolder {
        TextView textViewName;
        TextView textViewDescription;
        TextView textViewPrice;
        ImageView imageView;
        // Other views in your item layout if needed
    }
}
