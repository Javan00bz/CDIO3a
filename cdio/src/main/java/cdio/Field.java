package cdio;

import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Field {
	String nameOfField;

	public Field(String nameOfField) {
		this.nameOfField = nameOfField;

	}

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public void landOnField (GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		System.out.println("No action has been specified for this field");
	}


}