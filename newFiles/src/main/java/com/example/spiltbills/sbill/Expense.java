package com.example.spiltbills.sbill;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Expense {
	private String expenseName;
	private HashMap<ActivityAccount, Double> listOfPayee;
	private String payee;
	private double amount;

	public Expense(String name, HashMap<ActivityAccount, Double> listOfPayee) {
		this.expenseName = name;
		this.listOfPayee = listOfPayee;
		updateAmount();

	}

	public Expense(String name, String payee, double amount){
		this.expenseName = name;
		this.payee = payee;
		this.amount = amount;
	}
	public String getName() {
		return this.expenseName;
	}

	public HashMap<ActivityAccount, Double> getListOfPayee() {
		return listOfPayee;
	}

	public void changeName(String name) {
		this.expenseName = name;
	}

	/**Stores the expense name, total amount of the expense, and the people in the expense to the
	 * data base
	 * Ex.
	 * Hotel,total amount:234,list of payee:{abby=25, joyce=75}
	 * @param activity
	 */
	private void storeData(Activity activity) {
		//EX of data: name,total amount:(100),people list:{abby=25, joyce=75}
		String data =expenseName + ",total amount:" + getBalance() +",list of payee:" + listOfPayee.toString() + "\n";


		File file = new File("."+String.valueOf(activity.getName()));

		try (FileOutputStream outputStream = new FileOutputStream( file,true )) {
			//TODO: store the data in
			outputStream.write(data.getBytes());
		} catch (FileNotFoundException e){
			try {
				file.createNewFile();
				storeData(activity);
			} catch (Exception exception){
				System.out.println("New File Can't Be Created! ");
			}
		} catch (IOException ioexception){
			System.out.println(ioexception.toString());
		}
	}

	public void changeAmount(HashMap<ActivityAccount, Double> listOfPayee) {
		changePayeeList(listOfPayee);
		updateAmount();
	}
	private void changePayeeList(HashMap<ActivityAccount, Double> listOfPayee){
		this.listOfPayee = listOfPayee;
	}
	private void updateAmount(){
		for (ActivityAccount activityAccount: listOfPayee.keySet()) {
			activityAccount.changeAmount(listOfPayee.get(activityAccount));
		}
	}

	public void deletPeople(ActivityAccount account) {
		listOfPayee.remove(account);
		updateAmount();
	}

	public double getBalance(){
		double balance = 0;
		for (ActivityAccount activityAccount: listOfPayee.keySet()) {
			balance += listOfPayee.get(activityAccount);
		}
		return balance;
	}

	public void addPeople(ActivityAccount account,double amount) {
		listOfPayee.put(account,amount);
		updateAmount();
	}
}