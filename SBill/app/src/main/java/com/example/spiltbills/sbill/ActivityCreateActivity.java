package com.example.spiltbills.sbill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ayhan on 2018-02-13.
 */

public class ActivityCreateActivity extends Activity {
    public ActivityCreateActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_activity);

        final EditText numOfPeopleEditText = findViewById(R.id.num_people);
        final EditText editText = findViewById(R.id.activity_name);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button createBtn = findViewById(R.id.create_button);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ContactActivity.class);
                intent.putExtra("nameOfActivity", editText.getText());
                intent.putExtra("numOfPeople", numOfPeopleEditText .getText());
                startActivity(intent);
            }
        });

    }

}
