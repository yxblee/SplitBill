package com.example.spiltbills;

import android.content.Context;
import java.io.FileOutputStream;

import java.io.File;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity implements java.io.Serializable{
	private String activityName;
	private ArrayList<Expense> expenses;
	private HashMap<ActivityAccount,Double> peopleList;
	private RegisteredAccount owner; // whats this for? we haven't us it
	private int id;

	private static int ID_SERIES = 0;

	public Activity(String name, int numOfPeople, RegisteredAccount owner) {
		this.activityName = name;
		this.owner = owner;
		peopleList = new HashMap<>();
        expenses = new ArrayList<Expense>();
//        makePplList(numOfPeople,contacts);
        id = ++ID_SERIES;
        storeActivityData();
	}

	public int getID(){
		return id;
	}

	/** Stores the name of the Activity in a table
	 * activityName,activityId,listOPPl=totalAmountSpentThroughoutActivity
	 * Ex.
	 * Camping,123958,Abby=234, Joyce=45.34
	 * Skiing,348795,Steven=283,Brain=28.09
	 */
	private void storeActivityData() {



//		String data =activityName + "," + id + peopleList.toString() + "\n";
//
//		File file = new File("."+String.valueOf(owner.getID()));
//
//		try (FileOutputStream outputStream = new FileOutputStream( file,true )) {
//
//			outputStream.write(data.getBytes());
//		} catch (FileNotFoundException e){
//			try {
//				file.createNewFile();
//				storeActivityData();
//			} catch (Exception exception){
//					System.out.println("New File Can't Be Created! ");
//			}
//		} catch (IOException ioexception){
//			System.out.println(ioexception.toString());
//		}
	}

//	private void makePplList(int numOfPeople,List<String> contacts) {
//		peopleList.put(new ActivityAccount(owner),0);
//		int i = 1;
//		for (String name : contacts) {
//			peopleList.put(new ActivityAccount(name),0);
//			i++;
//		}
//		for (; i <= numOfPeople; i++) {
//			peopleList.put(new ActivityAccount(),0);
//		}
//	}

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
	        total += es.getBalance();
        }
        return total;
    }

//	public boolean deletePeople(String name) {
//		for (Account ac : peopleList) {
//			if(ac.getName() == name){
//				peopleList.remove(ac);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void addPeople(ActivityAccount account) {
//		peopleList.put(account,0);
//	}
}