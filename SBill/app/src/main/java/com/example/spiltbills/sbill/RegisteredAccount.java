package com.example.spiltbills.sbill;

import android.graphics.drawable.Icon;

import java.util.ArrayList;

/**
 * Created by Ayhan on 2018-02-13.
 */

public class RegisteredAccount extends Account{
    private String email;
//    private Icon picture;
    private int id;
    private ArrayList<ActivityAccount> listOfContact;
    protected static int ID_series = 0;

    public RegisteredAccount(String name, String email){
        super(name,++ID_series);
        this.email = email;
    }
    public boolean deletContact(String name) {
        boolean isRemoved = false;
        for(Account ac : listOfContact){
            if( ac.getName() == name){
                listOfContact.remove(ac);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public boolean addContact(ActivityAccount account) {
        listOfContact.add(account);
        return listOfContact.contains(account);
    }
}
