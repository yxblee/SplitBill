package com.example.spiltbills.sbill;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Ayhan on 2018-03-02.
 */

public class ExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense);

        Button doneBtn = findViewById(R.id.done);
        EditText expenseName = findViewById(R.id.expenseName);
        EditText nameText = findViewById(R.id.nameText);
        EditText amount = findViewById(R.id.amountText);
        String activityID = getIntent().getIntExtra("activityID",0) + "";


        doneBtn.setOnClickListener((view) -> {
            if(TextUtils.isEmpty(expenseName.getText().toString())){
                Toast.makeText(getApplicationContext(), "Expense name cannot be empty!", Toast.LENGTH_LONG).show();

            } else if(TextUtils.isEmpty(nameText.getText().toString())){
                Toast.makeText(getApplicationContext(), "Payee cannot be empty!", Toast.LENGTH_LONG).show();

            } else if(TextUtils.isEmpty(amount.getText().toString()) || Integer.parseInt(amount.getText().toString()) < 0 ){
                Toast.makeText(getApplicationContext(), "Amount cannot be empty!", Toast.LENGTH_LONG).show();

            } else {
                Expense expense = new Expense(expenseName.getText().toString(),expenseName.getText().toString(),Integer.parseInt(amount.getText().toString()));
                try {
                    File file = new File(activityID);
                    if (file.exists()) {
                        FileOutputStream fos = openFileOutput(activityID, Context.MODE_PRIVATE);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(expense);
                        fos.close();
                        oos.close();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
