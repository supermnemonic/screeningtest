package com.mnemonic.icomputer.screeningtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {

    public final static String EXTRA_CHOOSED_EVENT_NAME = "com.mnemonic.icomputer.screeningtest.CHOOSED_EVENT_NAME";

    ListView list;
    Event[] events = {
            new Event(R.drawable.icon_person, "Event Satu", "2016-1-4"),
            new Event(R.drawable.icon_person, "Event Dua", "2016-5-8"),
            new Event(R.drawable.icon_person, "Event Tiga", "2016-8-9"),
            new Event(R.drawable.icon_person, "Event Empat", "2016-10-15"),
            new Event(R.drawable.icon_person, "Event Lima", "2016-12-24")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        EventAdapter adapter=new EventAdapter(this, events);
        list=(ListView)findViewById(R.id.eventList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String selectedItem = events[+position].name;
                //Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra(EXTRA_CHOOSED_EVENT_NAME, selectedItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
