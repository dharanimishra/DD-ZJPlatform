package com.ziksana.id;

public class StringZID implements ZID {

	String id;

	public StringZID() {

	}

	public StringZID(String id) {
		this.id = id;
	}

	@Override
	public String getDisplayID() {

		return id;
	}

	@Override
	public void setDisplayID(String id) {

		this.id = id;
	}

	@Override
	public String getStorageID() {

		return id;
	}

	@Override
	public void setStorageID(String id) {

		this.id = id;
	}
}
