package cdio;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

//Klasse for spillets spillere
public class Player extends GUI_Player {
	
	private GUI_Car car;
	private int position;
	
	public Player(String name, int balance, int position, GUI_Car car) {
		super(name, balance, car);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}

