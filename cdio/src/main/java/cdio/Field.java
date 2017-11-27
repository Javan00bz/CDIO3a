package cdio;

import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public abstract class Field {
	protected String nameOfField;
	protected int fieldNumber;
	String[] guiMessages = Translater.file("Gamefunctions.txt");
	
	public Field(String nameOfField, int fieldNumber) {
		this.nameOfField = nameOfField;
		this.fieldNumber = fieldNumber;

	}

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}
	
	public void landOnField (GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		System.out.println(guiMessages[16]);
	}
	

	public int getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public Player getOwner() {
		return null;
	}


}