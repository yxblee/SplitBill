package com.example.spiltbills;

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

        Button addExpense = findViewById(R.id.addE);
        Button done = findViewById(R.id.done);

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

//               doneBtn.setOnClickListener((View view) -> {
//               if(TextUtils.isEmpty(expenseName.getText().toString())){
//               Toast.makeText(getApplicationContext(), "Expense name cannot be empty!", Toast.LENGTH_LONG).show();
//
//               } else if(TextUtils.isEmpty(nameText.getText().toString())){
//               Toast.makeText(getApplicationContext(), "Payee cannot be empty!", Toast.LENGTH_LONG).show();
//
//               } else if(TextUtils.isEmpty(amount.getText().toString()) || Integer.parseInt(amount.getText().toString()) < 0 ){
//        Toast.makeText(getApplicationContext(), "Amount cannot be empty!", Toast.LENGTH_LONG).show();
//
//        } else {
//        Expense expense = new Expense(expenseName.getText().toString(),expenseName.getText().toString(),Integer.parseInt(amount.getText().toString()));
//        try {
//        File file = new File(activityID);
//        if (file.exists()) {
//        FileOutputStream fos = openFileOutput(activityID, Context.MODE_PRIVATE);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(expense);
//        fos.close();
//        oos.close();
//        }
//        }catch (Exception e){
//        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//        }
//        }
//        });
