package com.example.spiltbills.sbill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        String nameOfActivity = getIntent().getStringExtra("nameOfActivity");
        int numOfPeople = getIntent().getIntExtra("numOfPeople", 0);
    }
}
