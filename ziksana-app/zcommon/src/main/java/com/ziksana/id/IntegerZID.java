package com.ziksana.id;

import java.io.Serializable;

public class IntegerZID implements ZID, Serializable {

	// int is preferred over Integer as we don't want this to be
	// a mutable reference type.
	int id;

	public IntegerZID(String id) {
		this.id = Integer.parseInt(id);
	}

	public IntegerZID(int id) {
		this.id = id;
	}

	public IntegerZID(Integer id) {
		this.id = id;
	}

	public String getDisplayID() {
		return Integer.toString(id);
	}

	public void setDisplayID(String id) {
		this.id = Integer.parseInt(id);
	}

	public String getStorageID() {
		return Integer.toString(id);
	}

	public void setStorageID(String id) {
		this.id = Integer.parseInt(id);
	}

	public void setStorageID(Integer id) {
		this.id = id;
	}

	public void setStorageID(int id) {
		this.id = id;
	}
	
	public String toString(){
		
		return new Integer(id).toString();
	}
}
