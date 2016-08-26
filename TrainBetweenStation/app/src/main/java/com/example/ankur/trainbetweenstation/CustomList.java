package com.example.ankur.trainbetweenstation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by ankur on 8/26/16.
 */
public class CustomList extends ArrayAdapter<String> {
    private String[] no;
    private String[] name;
    private String[] number;
    private Activity context;

    public CustomList(Activity context, String[] no, String[] name, String[] number) {
        super(context, R.layout.list_view_layout, no);
        this.context = context;
        this.no = no;
        this.name = name;
        this.number = number;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewNo = (TextView) listViewItem.findViewById(R.id.textViewNo);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewNumber = (TextView) listViewItem.findViewById(R.id.textViewNumber);

        textViewNo.setText(no[position]);
        textViewName.setText(name[position]);
        textViewNumber.setText(number[position]);

        return listViewItem;
    }
}
