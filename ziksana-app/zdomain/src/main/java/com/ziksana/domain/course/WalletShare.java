package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum WalletShare {

	// TODO: retrieve the ids from the static data service
	WALLETSHARE1	(1, "Wallet Share1");
	
	private final int id;
	private final String name;

	private WalletShare(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static WalletShare getWalletShare(int ID) {
		for (WalletShare walletShare : WalletShare.values()) {
			if (walletShare.getID() == ID) {
				return walletShare;
			}
		}

		throw new NoSuchElementException("WalletShare ID [" + ID + "] not found");
	}

	public String toString() {
		return "Wallet Share [" + getName() + "] ID [" + getID() + "]";
	}
}
