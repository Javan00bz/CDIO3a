package cdio;

import cdio.Account;

//Klasse for spillets spillere
public class Player {
	
	private String name;
	private int position;
	private Account account;
	private int firstRoll;
	private boolean prison = false;
	
	
	public Player(String name, int balance, int position) {
		this.name = name;
		this.position = position;
		this.account = new Account(balance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void setPrison(boolean prison) {
		this.prison = prison;
	}

	public boolean getPrison() {
		return prison;
	}
}


