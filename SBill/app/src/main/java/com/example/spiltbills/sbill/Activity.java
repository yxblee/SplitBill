package com.example.spiltbills.sbill;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Activity {
	private String activityName;
	private ArrayList<Expense> expenses;
	private ArrayList<ActivityAccount> peopleList;
	private RegisteredAccount owner; // whats this for? we haven't us it
	private int id;

	private static int ID_SERIES = 0;

	public Activity(String name, int numOfPeople, RegisteredAccount owner, List<String> contacts) {
		this.activityName = name;
		this.owner = owner;
		peopleList = new ArrayList<ActivityAccount>();
        expenses = new ArrayList<Expense>();
        makePplList(numOfPeople,contacts);
        id = ++ID_SERIES;
	}

	//Storing data into a local file
	protected void storeData() throws Exception {
		Context ctx;
		String data =activityName + "," + id + "\n";
		File file = new File("."+String.valueOf(owner.getID()));
		FileOutputStream fos;
		try {
			//TODO: store the data in
			fos = new FileOutputStream( file,true );
		} catch (FileNotFoundException e){
			try {
				file.createNewFile();
			} catch (Exception exception){
					System.out.println("New File Can't Be Created! ");
			}
		} finally {
			fos = new FileOutputStream( file,true );
			fos.write(data.getBytes());
			fos.close();
		}
	}


	private void makePplList(int numOfPeople,List<String> contacts) {
		peopleList.add(new ActivityAccount(owner));
		int i = 1;
		for (String name : contacts) {
			peopleList.add(new ActivityAccount(name));
			i++;
		}
		for (; i <= numOfPeople; i++) {
			peopleList.add(new ActivityAccount());
		}
	}

	public Expense getexpense(int index) {
		return expenses.get(index);
	}

	public String getName(){return activityName; }

	public boolean addExpenses(Expense es){
	    expenses.add(es);
	    return expenses.contains(es);
    }

    public int getNumOfPpl(){
	    return peopleList.size();
    }
	
	public void setName(String name) { // set the name of activity?
		this.activityName = name;
	}

	public double getCurrentTotal(){
	    double total = 0;
	    for( Expense es : expenses){
	        total += es.getAmount();
        }
        return total;
    }

	public boolean deletePeople(String name) {
		for (Account ac : peopleList) {
			if(ac.getName() == name){
				peopleList.remove(ac);
				return true;
			}
		}
		return false;
	}

	public void addPeople(ActivityAccount account) {
		peopleList.add(account);
	}
}