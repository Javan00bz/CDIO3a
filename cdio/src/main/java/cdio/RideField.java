package cdio;

import cdio.Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class RideField extends Field {

	int price;
	Player owner;
	String[] guiMessages = Translater.file("Gamefunctions.txt");

	public RideField(String nameOfField, int fieldNumber, int price, Player Owner) {
		super(nameOfField, fieldNumber);
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
		if (owner == null)
			buyField(gui, street, pl, Gpl);
		else payRent(gui, street, pl, Gpl);	
	}

	public void payRent(GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		if (GameBoard.sameOwner(Game.getBoard(), getFieldNumber() ) == true) {
			int price = getPrice() * 2;
			pl.getAccount().withdraw(price);
			getOwner().getAccount().deposit(price);
			gui.showMessage(pl.getName() + ", you landed on a field belongning to " + getOwner().getName() + " and you have to pay " + price + " dollars");
		}
		else 
		{ pl.getAccount().withdraw(getPrice());
		getOwner().getAccount().deposit(getPrice());
		gui.showMessage(pl.getName() + ", you landed on a field belongning to " + getOwner().getName() + " and you have to pay " + getPrice() + " dollars");
		}
	}


	public void buyField(GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		String userSelection = gui.getUserSelection(pl.getName() + guiMessages[12], guiMessages[10], guiMessages[11]);
		if (userSelection == guiMessages[10]) {
			street.setBorder(Gpl.getCar().getPrimaryColor());
			street.setOwnerName(pl.getName());
			pl.getAccount().withdraw(getPrice());
			setOwner(pl);
		}
	}
}
