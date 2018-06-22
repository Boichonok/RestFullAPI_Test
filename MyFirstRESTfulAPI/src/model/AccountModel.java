package model;
import java.util.*;
import entities.Account;

public class AccountModel {
	private List<Account> listAccount = new ArrayList<Account>();
	
	public AccountModel() {
		this.listAccount.add(new Account("acc1", "1235", new String[] {"superadmin","admin","employee"}));
		this.listAccount.add(new Account("acc2", "123", new String[] {"admin","employee"}));
		this.listAccount.add(new Account("acc3", "1234", new String[] {"employee"}));
	}
	
	public Account find(String username) {
		for(Account acc : this.listAccount)
			if(acc.getUserName().equalsIgnoreCase(username))
				return acc;
		
		return null;
	}
	public Account login(String username, String password) {
		for(Account acc : this.listAccount) {
			if(acc.getUserName().equals(username) && acc.getPassword().equals(password)) {
				return acc;
			}
		}
		return null;
	}
	 
}
