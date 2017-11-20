package cdio;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Empty;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Game {

	private GUI gui = new GUI(generateFields());
	private Player Player1;
	private Player Player2;
	private Player Player3;
	private Player Player4;
	private Player[] Players = {Player1, Player2, Player3, Player4};
	private GUI_Player GUI_Player1;
	private GUI_Player GUI_Player2;
	private GUI_Player GUI_Player3;
	private GUI_Player GUI_Player4;
	private GUI_Player[] GUI_Players = {GUI_Player1, GUI_Player2, GUI_Player3, GUI_Player4};
	private GUI_Car Car1;
	private GUI_Car Car2;
	private GUI_Car Car3;
	private GUI_Car Car4;
	private GUI_Car[] GUI_Cars = {Car1, Car2, Car3, Car4};
	private int startingMoney;
	private DiceCup cup = new DiceCup(1);
	private int amountOfPlayers;
	public static void main(String[] args) {
		new Game().playGame();
	}

	private void playGame(){


		startGame();
		for(int i = 0; i<amountOfPlayers; i++) {
			playerTurn(Players[i], GUI_Players[i]);
			if (i == amountOfPlayers-1)
				i=-1;}
	}

	private void startGame() {
		gui.showMessage("Welcome");
		amountOfPlayers = gui.getUserInteger("How many players are you", 2, 4);
		switch (amountOfPlayers) {
		case 2: startingMoney = 20;
		break;
		case 3: startingMoney = 18;
		break;
		case 4: startingMoney = 16;
		break;
		default: startingMoney = 20;
		}
		int j = 0;
		for(int i=0; i < amountOfPlayers; i++) {
			j++;
			String playerName = gui.getUserString("Player " + j + ", enter your name" );
			Players[i] = new Player(playerName, startingMoney, 0);
			String color = gui.getUserButtonPressed("Player " + j + ", choose the colour of your car", "RED", "GREEN", "BLUE", "YELLOW");
			GUI_Cars[i] = new GUI_Car();
			if (color == "RED") {
				GUI_Cars[i].setPrimaryColor(Color.RED);
			}
			if (color == "GREEN") {
				GUI_Cars[i].setPrimaryColor(Color.GREEN);
			}
			if (color == "BLUE") {
				GUI_Cars[i].setPrimaryColor(Color.BLUE);
			}
			if (color == "YELLOW") {
				GUI_Cars[i].setPrimaryColor(Color.YELLOW);
			}
			GUI_Players[i] = new GUI_Player(Players[i].getName(), Players[i].getAccount().getValue(), GUI_Cars[i]);
			gui.addPlayer(GUI_Players[i]);
			gui.getFields()[Players[i].getPosition()].setCar(GUI_Players[i], true);
		}

	}
	private void playerTurn(Player Pl, GUI_Player Gpl) {
		gui.showMessage("click to roll");
		cup.rollDiceCup();
		gui.setDice(cup.getDice()[0].getFaceValue(), 10, 3, 3, cup.getDice()[0].getFaceValue(), 10, 3, 3);
		gui.getFields()[Pl.getPosition()].setCar(Gpl, false);
		Pl.setPosition(Pl.getPosition() + cup.getDice()[0].getFaceValue());
		if (Pl.getPosition()<24)
			gui.getFields()[Pl.getPosition()].setCar(Gpl, true);
		else {
			Pl.setPosition(Pl.getPosition()-24);
			gui.getFields()[Pl.getPosition()].setCar(Gpl, true);
		}

	}

	private GUI_Field[] generateFields() {
		String[] fieldText = Translater.file("file1.txt");
		String[] fieldSubtext = Translater.file("file2.txt");
		String[] fieldRent = Translater.file("file3.txt");

		GUI_Field[] fields = new GUI_Field[24];
		for (int i = 0; i < fields.length; i++) {
			GUI_Street gui_street = new GUI_Street();
			gui_street.setTitle(fieldText[i]);
			gui_street.setSubText(fieldSubtext[i]);
			gui_street.setRent(fieldRent[i]);
			fields[i] = gui_street;
		}
		return fields;
	}

}