package com.example.spiltbills;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RegisteredAccount tempUser = null;
        final RegisteredAccount user;

        //read the log in account
        String fileName = getIntent().getStringExtra("fileName");
        File dir = getFilesDir();
        try {
            File file = new File(dir,fileName);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fis);
            tempUser = (RegisteredAccount)input.readObject();
            fis.close();
            input.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        user = tempUser;


        String nameOfActivity = getIntent().getStringExtra("nameOfActivity");
        int numOfPeople = getIntent().getIntExtra("numOfPeople", 0);

        Button finishedBtn = findViewById(R.id.finishButton);
        finishedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //write the activity to the file
                com.example.spiltbills.Activity activity = new Activity(getIntent().getStringExtra("activityName"),getIntent().getIntExtra("numOfPpl",0),user);
                String fileName = "activities";
                try {
                    File file = new File(fileName);
                    FileOutputStream fos = openFileOutput(fileName,Context.MODE_PRIVATE);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(activity);
                    fos.close();
                    oos.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

                String activityFN = activity.getID()+"";
                try {
                    File file = new File(activityFN);
                    file.createNewFile();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(getApplicationContext(),CurrentExpencesActivity.class);
                intent.putExtra("activityID", activity.getID());
                startActivity(intent);
            }
        });
    }
}
