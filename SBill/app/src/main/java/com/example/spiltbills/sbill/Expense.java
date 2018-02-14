package com.example.spiltbills.sbill;

import java.util.ArrayList;
import java.util.HashMap;

public class Expense {
	private String expenseName;
	private double expenseAmount;
	private HashMap<ActivityAccount, Double> listOfPayee;

	public Expense(String name, HashMap<ActivityAccount, Double> listOfPayee) {
		this.expenseName = name;
		this.listOfPayee = listOfPayee;
		updateAmount();

	}
	public String getName() {
		return this.expenseName;
	}

	public double getAmount() {
		return expenseAmount;
	}

	public HashMap<ActivityAccount, Double> getListOfPayee() {
		return listOfPayee;
	}

	public void changeName(String name) {
		this.expenseName = name;
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