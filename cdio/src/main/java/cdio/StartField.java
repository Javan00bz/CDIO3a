package cdio;

import cdio.Field;
import cdio.Account;
import cdio.Player;

public class StartField extends Field {
	
	int addmoney = 2;
	boolean buyable = false;

	public StartField(String nameOfField, int fieldNumber, String fieldType, boolean buyable) {
		super(nameOfField, fieldNumber, fieldType, buyable);
		this.addmoney = addmoney;
	}

	public boolean getStartfield() {
		return buyable;
	}
	
	public void setStartfield(boolean buyable) {
		this.buyable = buyable;
	}
	
	public void start(Player player) {
		player.getAccount().deposit(addmoney);
	}

}