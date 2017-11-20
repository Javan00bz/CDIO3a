package cdio;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Empty;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Game {

	private GUI gui = new GUI(generateFields());
	private Player[] Players;
	private GUI_Player[] GUI_Players;
	private int startingMoney;
	private DiceCup cup = new DiceCup(1);
	private int amountOfPlayers;
	public static void main(String[] args) {
		new Game().playGame();
	}

	private void playGame(){

		startGame();
		for(int i = 0; i<amountOfPlayers; i++) {
			playerTurn(i);
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
		Player[] Players = new Player[amountOfPlayers];
		GUI_Player[] GUI_Players = new GUI_Player[amountOfPlayers];
		int j = 0;
		for(int i=0; i < amountOfPlayers; i++) {
			j++;
			String playerName = gui.getUserString("Player " + j + ", enter your name" );
			Player player = new Player(playerName, startingMoney, 0);
			Players[i] = player;
			String color = gui.getUserButtonPressed("Player " + j + ", choose the colour of your car", "RED", "GREEN", "BLUE", "YELLOW");
			GUI_Car car = new GUI_Car();
			if (color == "RED") {
				car.setPrimaryColor(Color.RED);
			}
			if (color == "GREEN") {
				car.setPrimaryColor(Color.GREEN);
			}
			if (color == "BLUE") {
				car.setPrimaryColor(Color.BLUE);
			}
			if (color == "YELLOW") {
				car.setPrimaryColor(Color.YELLOW);
			}
			GUI_Player Gui_Player = new GUI_Player(Players[i].getName(), Players[i].getAccount().getValue(), car);
			GUI_Players[i] = Gui_Player;
			gui.addPlayer(GUI_Players[i]);
			gui.getFields()[Players[i].getPosition()].setCar(GUI_Players[i], true);
		}
		this.Players = Players;
		this.GUI_Players = GUI_Players;

	}
	private void playerTurn(int cp) {
		gui.showMessage("click to roll");
		cup.rollDiceCup();
		gui.setDice(cup.getDice()[0].getFaceValue(), 10, 3, 3, cup.getDice()[0].getFaceValue(), 10, 3, 3);
		gui.getFields()[Players[cp].getPosition()].setCar(GUI_Players[cp], false);
		Players[cp].setPosition(Players[cp].getPosition() + cup.getDice()[0].getFaceValue());
		if (Players[cp].getPosition()<24)
			gui.getFields()[Players[cp].getPosition()].setCar(GUI_Players[cp], true);
		else {
			Players[cp].setPosition(Players[cp].getPosition()-24);
			gui.getFields()[Players[cp].getPosition()].setCar(GUI_Players[cp], true);
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