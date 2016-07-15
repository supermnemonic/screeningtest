package com.mnemonic.icomputer.screeningtest;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    public final static String EXTRA_PERSON_NAME = "com.mnemonic.icomputer.screeningtest.PERSON_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void submitPerson(View view) {
        Intent intent = new Intent(this, MainScreenActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_person_name);
        String personName = editText.getText().toString();
        intent.putExtra(EXTRA_PERSON_NAME, personName);
        startActivity(intent);
    }
}
