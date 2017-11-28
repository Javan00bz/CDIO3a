package cdio;

import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class SpecialField extends Field {

	int fee;
	String[] guiMessages = Translater.file("Gamefunctions.txt");
	
	public SpecialField(String nameOfField, int fieldNumber, int fee) {
		super(nameOfField, fieldNumber);
		this.fee=fee;
	
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public void landOnField(GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		if (getNameOfField().equals("DOLPHIN SHOW"))
			gui.showMessage(pl.getName() + guiMessages[18] + getFee() + guiMessages[19]);
		pl.getAccount().withdraw(getFee());
		
	}	
}
