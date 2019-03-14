package com.example.spiltbills;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splitbills.R;

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

        //Buttons
        Button doneBtn = findViewById(R.id.done);
        ImageButton morePayer = findViewById(R.id.morePayer);
        Button subExpense = findViewById(R.id.subE);
        Button participant = findViewById(R.id.participant);
        Button done = findViewById(R.id.done);

        //inputs
        EditText expenseName = findViewById(R.id.expenseName);
        EditText nameText = findViewById(R.id.nameText);
        EditText amount = findViewById(R.id.amountText);
        double total = 0.00;

        //outputs
        TextView totalCost = findViewById(R.id.expenseCost);

        String activityID = getIntent().getIntExtra("activityID",0) + "";

        //TODO: add a change listener that updates Expense Cost after enter the Amount
        amount.addTextChangedListener(new TextWatcher() {
            Double adding = 0.0;
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {
                    try {

                        adding = Double.parseDouble(amount.getText().toString());

                        totalCost.setText("$"+adding.toString()); //TODO: doesn't update the total cost view
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), amount.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    totalCost.setText("$0.0");
                }
            }
        });

        //TODO: when "+" is clicked, add a new field to enter Name and Amount

        //TODO:when SUBEXPENSE is clicked, allow for subexpense information to be added, so that it
            //is removed from the total when the bills is split

        //TODO: Participant- allow to remove some participants from the expense

        //TODO: DONE BUTTON
        doneBtn.setOnClickListener((View view) -> {
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
                Intent intent = new Intent(getBaseContext(), ContactActivity.class);
                intent.putExtra("nameOfActivity", nameText.getText());
                //intent.putExtra("numOfPeople", numOfPeopleEditText.getText());
                startActivity(intent);
            }
        });

    }
}
