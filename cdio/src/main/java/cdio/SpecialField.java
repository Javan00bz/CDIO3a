package cdio;

import gui_main.GUI;

public class SpecialField extends Field {

	int fee;
	
	public SpecialField(String nameOfField, int fee) {
		super(nameOfField);
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
