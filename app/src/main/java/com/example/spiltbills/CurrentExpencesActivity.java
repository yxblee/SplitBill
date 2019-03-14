package com.example.spiltbills;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.splitbills.R;

import java.util.ArrayList;
import java.util.List;

public class CurrentExpencesActivity extends AppCompatActivity implements Adapter.OnItemClickListener{
    //RecyclerView
    RecyclerView recyclerView;
    Adapter adapter;
    List<Expense> expenseList;
    public static final String EXTRA_EXDETAILS = "expenseDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_expences);
        int activityID = getIntent().getIntExtra("activityID",0);

        //loading data
        loadViewData();

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

        expenseList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.expenseRcyView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        expenseList.add(
                new Expense("me","Debit",64.52)
        );
        expenseList.add(
                new Expense("you","Debit",64.52)
        );
        expenseList.add(
                new Expense("das","Debit",64.52)
        );
        expenseList.add(
                new Expense("yodasu","Debit",64.52)
        );
        expenseList.add(
                new Expense("yfafou","Debit",64.52)
        );
        expenseList.add(
                new Expense("yfasfasou","Debit",64.52)
        );
        expenseList.add(
                new Expense("yoqwewqu","Debit",64.52)
        );
        expenseList.add(
                new Expense("ygrgeou","Debit",64.52)
        );
        expenseList.add(
                new Expense("youkjhkhj","Debit",64.52)
        );
        expenseList.add(
                new Expense("yluiluou","Debit",64.52)
        );

        adapter = new Adapter().ExpenseAdapter(this,expenseList,"EXPENSE_ADAPTER");
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(CurrentExpencesActivity.this);
    }
    //Loading data
    private void loadViewData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
    }

    //Recycler data onclick detail
    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        Expense clickedExpense = expenseList.get(position);


        //Retrieve details of this clicked activity
        String[] strings = new String[] { clickedExpense.getName()};
        detailIntent.putExtra(EXTRA_EXDETAILS,strings);
        //Begin the detail activity
        startActivity(detailIntent);
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
