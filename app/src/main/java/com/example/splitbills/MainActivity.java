package com.example.splitbills;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{
    //we should get the user's account.
    private RegisteredAccount user = new RegisteredAccount("name","email");
    private String mainSearch;

    //RecyclerView
    RecyclerView recyclerView;
    Adapter adapter;
    List<Activity> activityList;
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_DETAILS = "activityDetail";

    private DatabaseReference mDatabase;
    private ArrayList<String> mKeys = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading data
        loadViewData();

        //Init Firebase reference
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Activity");

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

    activityList = new ArrayList<Activity>();
    recyclerView = (RecyclerView) findViewById(R.id.mainContent);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RegisteredAccount registeredAccount = new RegisteredAccount("me","cxd");

    mDatabase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            /*Iterable<DataSnapshot> children = dataSnapshot.getChildren();

            for(DataSnapshot child : children) {
                Activity activity = child.getValue(Activity.class);
                activityList.add(activity);

            }
            adapter.notifyDataSetChanged();*/
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
        adapter = new Adapter().mainAdapter(this,activityList,"MAIN_ADAPTER");
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(MainActivity.this);
   /* mDatabase.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            //HashMap<String,Object> value = dataSnapshot.getValue(HashMap.class);
            Log.d("***********", dataSnapshot.getValue().toString());
            Activity act = dataSnapshot.child("Activity_dasd").getValue(Activity.class);

            activityList.add( act);
            adapter.notifyDataSetChanged();

            //Key for a value in firebase
            //String key = dataSnapshot.getKey();
            //mKeys.add(key);
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            String value = dataSnapshot.child("Activity_one").child("name").getValue(String.class);
            String key = dataSnapshot.getKey();

            int index = mKeys.indexOf(key);
            Activity newActivity = new Activity(value,3,registeredAccount);
            activityList.set(index, newActivity);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });*/
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
        Activity clickedActivity = activityList.get(position);

        //Retrieve details of this clicked activity
        String[] strings = new String[] { clickedActivity.getName(), String.valueOf(clickedActivity.getNumOfPpl()), String.valueOf(clickedActivity.getCurrentTotal())};
        detailIntent.putExtra(EXTRA_DETAILS,strings);

        //Begin the detail activity
        startActivity(detailIntent);
    }
}