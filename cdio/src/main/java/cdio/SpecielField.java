package cdio;

import gui_main.GUI;

public class SpecielField extends Field {

	int fee;
	
	public SpecielField(String nameOfField, int fieldNumber, String fieldType, boolean buyable, int fee) {
		super(nameOfField, fieldNumber, fieldType, buyable);
		this.fee=fee;
	
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public void landOnField (Player pl, GUI gui) {
		gui.showMessage("Dolphin");
		pl.getAccount().withdraw(getFee());
	}	
}
