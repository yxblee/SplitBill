package com.example.spiltbills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.spiltbills.R.layout.activity_contact);


        String nameOfActivity = getIntent().getStringExtra("nameOfActivity");
        int numOfPeople = getIntent().getIntExtra("numOfPeople", 0);
    }
}
