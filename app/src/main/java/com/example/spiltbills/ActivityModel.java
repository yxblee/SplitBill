package com.example.spiltbills;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public boolean createActivity(String name, int numOfPpl) {
        if(isNameValid(name)) {
            Activity activity = new Activity(name, numOfPpl, owner,contacts);
            activities.add(activity);
            return activities.contains(activity);
        }

        System.out.println("activity not created");
        return false;
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

    public boolean removeAccount(String name) {
        return owner.deletContact(name);
    }



}
