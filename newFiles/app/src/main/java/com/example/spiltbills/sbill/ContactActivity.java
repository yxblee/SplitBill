package com.example.spiltbills.sbill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        String nameOfActivity = getIntent().getStringExtra("nameOfActivity");
        int numOfPeople = getIntent().getIntExtra("numOfPeople", 0);

        Button finishedBtn = findViewById(R.id.finishButton);
        finishedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CurrentExpencesActivity.class);
                startActivity(intent);
            }
        });
    }
}
