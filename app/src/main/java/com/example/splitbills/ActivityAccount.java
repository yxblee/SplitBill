package com.example.spiltbills;

/**
 * Created by Ayhan on 2018-02-13.
 */

public class ActivityAccount extends Account {
    private double amount;


    public ActivityAccount(){
        super();
    }

    public ActivityAccount(String name){
        super(name);
    }

    public ActivityAccount(RegisteredAccount ra){
        super(ra.name,ra.getID());
    }
    public void changeAmount(double amount){
        this.amount = amount;
    }

    public void addAmount(double amount){
        this.amount += amount;
    }
}
