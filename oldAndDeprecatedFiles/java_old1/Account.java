package com.example.spiltbills.sbill;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

import java.util.ArrayList;

public class Account {
	private String name;
	private String email;
	private Icon picture;
	private ArrayList<Account>listOfContact;
	private int id;
	
	public static final String DEFAULT_NAME = "User";
	public static final String DEFAULT_EMAIL = "none";
//	public static final Icon DEFAULT_PIC = new Icon();//don't know how to initialize
	public static final int DEFAULT_ID = 1000;//not sure how are we going to generate, right now just doing increasing by one after each call
	
	public Account() {
		this.name = DEFAULT_NAME;
		this.email = DEFAULT_EMAIL;
//		this.picture = DEFAULT_PIC;
		this.id = DEFAULT_ID;
		listOfContact = new ArrayList<Account>();
		id++;
	}

	public Account(String aName) {
		this.name = aName;
		listOfContact = new ArrayList<Account>();
		id++;
	}

	//we don't need "String password"
	public Account(String aName, String anEmail) {
		this.name = aName;
		this.email = anEmail;
		listOfContact = new ArrayList<Account>();
		id++;
	}

	//we don't need changPW
	public void changeName(String newName) {
		this.name = newName;
	}

	public void changePicture(Icon newPicture) {
		this.picture = newPicture;
	}

	public String getName() {
		return this.name;
	}

	public Icon getPic() {
		return picture;
	}

	public boolean deletPeople(int index) {
		return listOfContact.remove(listOfContact.get(index));
	}

	public void addPeople(Account account) {
		listOfContact.add(account);
	}
}