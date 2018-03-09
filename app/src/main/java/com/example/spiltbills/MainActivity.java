package com.example.spiltbills;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private String mainSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.spiltbills.R.layout.activity_main);


        System.out.print("this is model!");
        SearchView mainSearchBar= findViewById(com.example.spiltbills.R.id.searchBar);

        RecyclerView mainRecyclerView = findViewById(com.example.spiltbills.R.id.mainContent);


        FloatingActionButton btn = (FloatingActionButton) findViewById(com.example.spiltbills.R.id.AddBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getApplicationContext(), R.string.hello_world, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ActivityCreateActivity.class);
                startActivity(intent);
            }
        });

//        mainRecyclerView.setAdapter(new ArrayAdapter<>());
    }


}
