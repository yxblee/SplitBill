package com.example.spiltbills.sbill;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private Model mainModel = new Model();
    private String mainSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        System.out.print("this is model!");

        FloatingActionButton mainAddButton = findViewById(R.id.AddBtn);
        SearchView mainSearchBar= findViewById(R.id.searchBar);

        RecyclerView mainRecyclerView = findViewById(R.id.mainContent);
    }


}
