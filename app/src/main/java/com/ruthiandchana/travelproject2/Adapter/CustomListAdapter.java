package com.ruthiandchana.travelproject2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.ruthiandchana.travelproject2.Entities.Travel;
import com.ruthiandchana.travelproject2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom list adapter, implementing BaseAdapter
 */
public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Travel> items;

    public CustomListAdapter(Context context, ArrayList<Travel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total item in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns the item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                inflate(R.layout.layout_list_view_row_items, parent, false);
        }

        // get current item to be displayed
        Item currentItem = (Item) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
            convertView.findViewById(R.id.text_view_item_name);
        TextView textViewItemDescription = (TextView)
            convertView.findViewById(R.id.text_view_item_description);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getItemName());
        textViewItemDescription.setText(currentItem.getItemDescription());

        // returns the view for the current row
        return convertView;
    }

*/




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_row_items2, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Travel currentItem = (Travel) getItem(position);
        viewHolder.clientName.setText(currentItem.getClientName());
        viewHolder.clientPhone.setText(currentItem.getClientPhone());
        viewHolder.clientEmail.setText(currentItem.getClientEmail());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView clientName;
        TextView clientPhone;
        TextView clientEmail;

        public ViewHolder(View view) {
            clientName = (TextView)view.findViewById(R.id.clientName);
            clientPhone = (TextView) view.findViewById(R.id.clientPhone);
            clientEmail = (TextView) view.findViewById(R.id.clientEmail);
        }
    }
}
