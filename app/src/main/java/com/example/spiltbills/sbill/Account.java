package com.example.spiltbills.sbill;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Account {
	protected String name;
	protected int id;

	protected static final String DEFAULT_NAME = "User";
	protected static final int  DEFAULT_ID = 0;

	protected  static final String DATA_FILE = "Accounts.csv";
//	public static final Icon DEFAULT_PIC;//don't know how to initialize

	protected Account() {
		this.name = DEFAULT_NAME;
		this.id = DEFAULT_ID;
	}

	protected Account(String aName) {
		this.name = aName;
		id = DEFAULT_ID;
	}

	protected Account(String name, int id){
		this.name = name;
		this.id = id;
	}




	//we don't need changPW
	public void changeName(String newName) {
		this.name = newName;
	}

//	public void changePicture(Icon newPicture) {
//		this.picture = newPicture;
//	}

	public String getName() {
		return this.name;
	}

//	public Icon getPic() {
//		return picture;
//	}

	protected int getID(){
		return id;
	}
}