package com.example.spiltbills;

import android.content.Context;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Ayhan on 2018-02-02.
 */

public class ActivityModel {
    List<Activity> activities;
    List<String> contacts;
    RegisteredAccount owner;

    public ActivityModel (RegisteredAccount owner) {
        this.activities = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.owner = owner;
    }

    //Creates an Activity
    public Activity createActivity(String name, int numOfPpl) {
        if(isNameValid(name)) {
            Activity activity = new Activity(name, numOfPpl, owner);
            activities.add(activity);
            return activity;
        }

        System.out.println("activity not created");
        return null;
    }

    private boolean isNameValid(String name){
        Scanner scanner = new Scanner("." + owner.getID());//need a way to access file
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(String str : line.split(","))
                if(str == name)
                    return false;
        }
        return true;
    }



    //Search for an Activity
    public List<Activity> searchActivity(String input) {
        List<Activity> matchActivities = new ArrayList<>();
        for ( Activity a : activities){
            if(a.getName().contains(input)){
                matchActivities.add(a);
            }
        }
        return matchActivities;

    }


    public boolean addAccount(String name) {
        return owner.addContact(new ActivityAccount(name) );
    }

//    public boolean removeAccount(String name) {
//        return owner.deletContact(name);
//    }



}
