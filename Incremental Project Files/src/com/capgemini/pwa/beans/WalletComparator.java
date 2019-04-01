package com.capgemini.pwa.beans;

import java.util.Comparator;

public class WalletComparator implements Comparator<Wallet> {

	@Override
	public int compare(Wallet o1, Wallet o2) {
		// TODO Auto-generated method stub
		if (o1.viewBalance() > o2.viewBalance()){
			return 1;
		}
		else if (o1.viewBalance() < o2.viewBalance()){
			return 0;	
		}
		return -1;
	}

	
}
