package com.example.spiltbills.sbill;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mainSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        System.out.print("this is model!");
        SearchView mainSearchBar= findViewById(R.id.searchBar);
        mainSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //searchAdapter.getFilter().filter(newText);
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_LONG).show();
                return true;
            }
        });



        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.AddBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getApplicationContext(), R.string.hello_world, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ActivityCreateActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView mainRecyclerView = findViewById(R.id.mainContent);
//        mainRecyclerView.setAdapter(new ArrayAdapter<>());



    }


}