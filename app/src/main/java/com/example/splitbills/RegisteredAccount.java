package com.example.spiltbills;

import android.content.Context;
import android.graphics.drawable.Icon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ayhan on 2018-02-13.
 */

public class RegisteredAccount extends Account implements java.io.Serializable{
    private String email;
//    private Icon picture;
    private int id;

    private ArrayList<ActivityAccount> listOfContact;
    protected static int ID_series = 0;

    public RegisteredAccount(String name, String email){
        super(name,++ID_series);
        this.email = email;
    }

    public RegisteredAccount( int id, String name, String email){
        this.id = id;
        this.email = email;
        this.changeName(name);
    }

    public boolean deleteContact(String name) {
        boolean isRemoved = false;
        for(Account ac : listOfContact){
            if( ac.getName() == name){
                listOfContact.remove(ac);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public String getEmail() { return this.email; }

    private void createFolder(){
        File folder = new File("."+String.valueOf(this.getID()));
        try {
            folder.mkdir();
            System.out.println("FOLDER CREATED!");
        }catch (SecurityException se){
            //we should let user give us the permission
        }
    }

    public boolean addContact(ActivityAccount account) {
        listOfContact.add(account);
        return listOfContact.contains(account);
    }

    /**Stores the account names and id
     *Account name,id
     * James,234
     *Jason,21394
     */
    public void storeData(ActivityAccount account) {

        String data =account.getName() + "," + account.getID() + "\n";

        File file = new File("." + String.valueOf(this.id) + "contact");

        try (FileOutputStream outputStream = new FileOutputStream( file,true )) {
            //TODO: store the data in
            outputStream.write(data.getBytes());
        } catch (FileNotFoundException e){
            try {
                file.createNewFile();
                storeData(account);
            } catch (Exception exception){
                System.out.println("New File Can't Be Created! ");
            }
        } catch (IOException ioexception){
            System.out.println(ioexception.toString());
        }
    }


}
