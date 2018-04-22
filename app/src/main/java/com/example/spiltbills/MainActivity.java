package com.example.spiltbills;

import android.content.Context;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    //we should get the user's account.
    private RegisteredAccount user = new RegisteredAccount("name","email");
    private String mainSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String fileName = "currentLogInAccount";
        ObjectOutput out = null;

        try {
            File file = new File(fileName);
            FileOutputStream fos = openFileOutput(fileName,Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            fos.close();
            oos.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }



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
                intent.putExtra("fileName","currentLogInAccount");
                startActivity(intent);
            }
        });

        //RecyclerView
        RecyclerView mainRecyclerView = findViewById(R.id.mainContent);
//        mainRecyclerView.setAdapter(new ArrayAdapter<>());



    }


}