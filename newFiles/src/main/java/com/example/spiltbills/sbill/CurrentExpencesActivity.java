package com.example.spiltbills.sbill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CurrentExpencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_expences);
        int activityID = getIntent().getIntExtra("activityID",0);

        Button addExpense = findViewById(R.id.addExpence);

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ExpenseActivity.class);
                intent.putExtra("activityID",activityID);
                startActivity(intent);
            }
        });
    }
}
