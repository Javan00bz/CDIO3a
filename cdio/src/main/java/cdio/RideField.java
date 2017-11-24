package cdio;

import cdio.Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class RideField extends Field {

	int price;
	Player owner;
	String[] guiMessages = Translater.file("Gamefunctions.txt");

	public RideField(String nameOfField, int price, Player Owner) {
		super(nameOfField);
		this.price = price;
		this.owner = owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public void landOnField(GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		if (owner == null) {
			String userSelection = gui.getUserSelection(guiMessages[12], guiMessages[10], guiMessages[11]);
			if (userSelection == guiMessages[10]) {
				street.setBorder(Gpl.getCar().getPrimaryColor());
				street.setOwnerName(pl.getName());
				pl.getAccount().withdraw(getPrice());
				setOwner(pl);
			}
		}
		else {
		pl.getAccount().withdraw(getPrice());
		getOwner().getAccount().deposit(getPrice());
		}
	}
}
