package com.example.spiltbills.sbill;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayhan on 2018-02-02.
 */

public class Model {
    List<Activity> activities;
    List<Account> contacts;

    public Model () {
        this.activities = new ArrayList<>();
        this.contacts = new ArrayList<>();
    }

    public List<Activity> searchActivity(String input) {
        //TODO
        
        return null;

    }

    public boolean createActivity(String name, int numOfPpl ) {
        //TODO
        //This function will check if the activity is create successfully or not
        return false;
    }

    public boolean addAccount(String name) {
        //TODO
        return false;
    }
    public boolean removeAccount(String name) {
        //TODO
        return false;
    }

    public boolean addExpense(String billName, double amount, Account payee) {
        //TODO
        return false;
    }

    public double getCurrentBalance(Activity activity) {
        //TODO
        return 0;
    }

    public int getNumOfPpl(Activity activity) {
        //TODO
        return 0;
    }

    public double getCurrentAvg(Activity activity) {
        //TODO
        return 0;
    }
    public boolean btnPressed(Button btn) {
        return false;
    }






}
