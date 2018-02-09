package com.example.spiltbills.sbill;

import java.util.ArrayList;

public class Activity {
	private String activityName;
	private ArrayList<Bill> billList;
	private ArrayList<Account> peopleList;
	private Account owner; // whats this for? we havent us it
	private int id;
	
	public Activity(String name, int numOfPeople) { //whats numOfPeople for? its arraylist we just getSize?
		this.activityName = name;
		peopleList = new ArrayList<Account>();
		billList = new ArrayList<Bill>();
	}

	public Bill getBill(int index) {
		return billList.get(index);
	}
	
	public void setName(String name) { // set the name of activity?
		this.activityName = name;
	}

	public boolean deletePeople(int index) {
		return peopleList.remove(peopleList.get(index));
	}

	public void addPeople(Account account) {
		peopleList.add(account);
	}
}