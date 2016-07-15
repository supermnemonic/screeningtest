package com.mnemonic.icomputer.screeningtest;

import android.app.Activity;
import android.icu.text.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by iComputer on 15-07-2016.
 */
public class EventAdapter extends ArrayAdapter<Event> {

    private final Activity context;
    private final Event[] events;

    public EventAdapter(Activity context, Event[] events) {
        super(context, R.layout.item_list_event, events);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.events=events;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_event, null,true);

        TextView txtName = (TextView) rowView.findViewById(R.id.eventName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.eventIcon);
        TextView txtDate = (TextView) rowView.findViewById(R.id.eventDate);

        txtName.setText(events[position].name);
        imageView.setImageResource(events[position].image);
        txtDate.setText(new SimpleDateFormat("dd MMM yyyy").format(events[position].date));
        return rowView;
    };
}
