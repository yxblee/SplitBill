package com.example.spiltbills;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by Ayhan on 2018-02-13.
 */

public class ActivityCreateActivity extends Activity {
    public ActivityCreateActivity() {
        super();
    }
    private ActivityModel model;
    RegisteredAccount user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_activity);




        final EditText numOfPeopleEditText = findViewById(R.id.num_people);
        final EditText nameText = findViewById(R.id.activity_name);

        model = new ActivityModel( user );

        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button createBtn = findViewById(R.id.create_button);

        //TODO:
        createBtn.setOnClickListener(view -> {
            if(TextUtils.isEmpty(nameText.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Activity name cannot be empty!",
                        Toast.LENGTH_LONG).show();
            } else if(TextUtils.isEmpty(numOfPeopleEditText.getText().toString()) ||
                    Integer.parseInt(numOfPeopleEditText.getText().toString()) == 0) {
                Toast.makeText(getApplicationContext(), "# of PPL cannot be 0 or empty!",
                        Toast.LENGTH_LONG).show();
            } else {

                Intent intent = new Intent(getBaseContext(), ContactActivity.class);
                intent.putExtra("nameOfActivity", nameText.getText());
                intent.putExtra("numOfPeople", numOfPeopleEditText.getText());
                startActivity(intent);
            }
        });
    }
}
