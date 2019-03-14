package com.example.spiltbills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.spiltbills.CurrentExpencesActivity.EXTRA_EXDETAILS;
import static com.example.spiltbills.MainActivity.EXTRA_DETAILS;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] details = new String[0];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if(intent.getStringArrayExtra(EXTRA_EXDETAILS) != null) {
           details = intent.getStringArrayExtra(EXTRA_EXDETAILS);
        }
        if(intent.getStringArrayExtra(EXTRA_DETAILS) != null) {

           details = intent.getStringArrayExtra(EXTRA_DETAILS);
        }
        TextView textViewDetails = findViewById(R.id.avtivityDetail);
        String detail = "";
            for (int i = 0; i < details.length; i++) {
                detail += details[i];
                detail += "\n";
            }
        textViewDetails.setText(detail);

    }
}
