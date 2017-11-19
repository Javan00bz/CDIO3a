package cdio;

import java.awt.Color;

import cdio.Fields.FieldAction;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;


public class Main {

	
	
	private static Object[] GUI_field;
	private static FieldAction[] fieldActions;
	
	public static void main(String[] args) {

		GUI_Field[] fields = generateFields();
		GUI gui = new GUI(fields);

		String amountOfPlayers = gui.getUserButtonPressed("How many players?", "2", "3", "4");
		int playerCount = Integer.parseInt(amountOfPlayers);
		
		Player[] players = new Player[playerCount];
		for(int i = 0; i < players.length; i++)
		{
			players[i] = generatePlayers(gui);
			
		}
		
		DiceCup dicecup = new DiceCup(1);
		while(true) {
			
			for(int i = 0; i < playerCount; i++)
			{
				Player player = players[i];
				playerTurn(gui, player, dicecup);
				fieldActions[player.getPosition()].action(player, players, fields[player.getPosition()], gui);
			}
		}
	}





	private static void playerTurn(GUI gui, Player player, DiceCup dicecup) {
		int position = player.getPosition();
		gui.getUserButtonPressed("next", "next");
		gui.getFields()[position].setCar(player, false);
		dicecup.rollDiceCup();
		gui.setDice(dicecup.getSum(), dicecup.getSum(), 1, 1, dicecup.getSum(), dicecup.getSum(), 1, 1);
		position = position + dicecup.getSum();
		if (position>23)
			position = position -23;
		gui.getFields()[position].setCar(player, true);
		
		player.setPosition(position);
	}


	private static Player generatePlayers(GUI gui) {
		GUI_Car gui_car1 = new GUI_Car(Color.WHITE, Color.WHITE, Type.TRACTOR, Pattern.CHECKERED);
		gui_car1 = userDefinedCar(gui);
		Player Player1 = new Player(gui.getUserString("indtast navn"), 0, 1000, gui_car1);
		gui.getFields()[0].setCar(Player1, true);

		return Player1;
	}

	private static GUI_Field[] generateFields() {
		String[] fieldText = Translater.file("file1.txt");
		String[] fieldDescription = Translater.file("file2.txt");
		
		GUI_Field[] fields = new GUI_Field[24];
		fieldActions = new FieldAction[fields.length];
		for (int i = 0; i < fields.length; i++) {
			GUI_Street gui_street = new GUI_Street();
			gui_street.setTitle(fieldText[i]);
			fields[i] = gui_street;
		}
		
		//Specify field actions
		for(int i = 0; i < fields.length; i++)
		{
			fieldActions[i] = Fields.empty;
			/*
			fieldActions[i] = new FieldAction() {
				public void action(Player player, Player[] players, GUI_Field field, GUI gui) {
					
				}
			};
			*/
		}
		
		
		return fields;
	}

	private static GUI_Car userDefinedCar(GUI gui) {
		String color = gui.getUserButtonPressed("choose the colour of your car", "RED", "GREEN", "BLUE", "YELLOW");

		GUI_Car gui_car = new GUI_Car();
		if (color == "RED") {
			gui_car.setPrimaryColor(Color.RED);
		}
		if (color == "GREEN") {
			gui_car.setPrimaryColor(Color.GREEN);
		}
		if (color == "BLUE") {
			gui_car.setPrimaryColor(Color.BLUE);
		}
		if (color == "YELLOW") {
			gui_car.setPrimaryColor(Color.YELLOW);
		}
		return gui_car;
	}

}


