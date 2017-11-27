package cdio;

import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class PrisonField extends Field {

	int fee = 1;

	public PrisonField(String nameOfField, int fieldNumber, int fee) {
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
		pl.getAccount().withdraw(getFee());
		Gpl.setBalance(pl.getAccount().getValue());
		gui.getFields()[pl.getPosition()].setCar(Gpl, false);
		pl.setPosition(6);
		gui.getFields()[pl.getPosition()].setCar(Gpl, true);		
	}	
}
