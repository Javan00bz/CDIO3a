package cdio;

import cdio.Field;

public class StartField extends Field {
	
	int addmoney = 2;
	boolean buyable = false;

	public StartField(String nameOfField, int fieldNumber, String fieldType, boolean buyable) {
		super(nameOfField, fieldNumber, fieldType, buyable);
		this.addmoney = addmoney;
	}

	

}