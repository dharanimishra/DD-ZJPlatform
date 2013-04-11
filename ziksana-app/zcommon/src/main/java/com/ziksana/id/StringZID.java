package com.ziksana.id;

public class StringZID implements ZID {

	String id;

	public StringZID() {

	}

	public StringZID(String id) {
		this.id = id;
	}

	public String getDisplayID() {

		return id;
	}

	public void setDisplayID(String id) {

		this.id = id;
	}

	public String getStorageID() {

		return id;
	}

	public void setStorageID(String id) {

		this.id = id;
	}
}
