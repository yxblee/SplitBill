package com.example.spiltbills.sbill;

import java.util.ArrayList;

public class Bill {
	private String billName;
	private double billAmount;
	private ArrayList<Account>listOfPeople;
	
	public Bill(String name, double amount) {
		this.billName = name;
		this.billAmount = amount;
	}
	public Bill(String name, double amount, ArrayList<Account> pListOfPeople) {
		this.billName = name;
		this.billAmount = amount;
		listOfPeople = pListOfPeople;
	} 
	public String getName() {
		return this.billName;
	}

	public double getAmount() {
		return billAmount;
	}

	public ArrayList<Account> getListOfPeople() {
		return listOfPeople;
	}

	public void changeName(String name) {
		this.billName = name;
	}

	public void changeAmount(double amount) {
		this.billAmount = amount;
	}

	public boolean deletPeople(int index) {
		return listOfPeople.remove(listOfPeople.get(index));
	}

	public void addPeople(Account account) {
		listOfPeople.add(account);
	}
}