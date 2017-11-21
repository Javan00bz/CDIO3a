package cdio;

import java.awt.Color;
import cdio.StartField;
import cdio.Player;
import cdio.StartField;

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
		String[] guiMessages = Translater.file("Gamefunctions.txt");
		startGame(guiMessages);
		for(int i = 0; i<amountOfPlayers; i++) {
			playerTurn(i, guiMessages);
			if (i == amountOfPlayers-1)
				i=-1;}
	}

	private void startGame(String[] guiMessages) {
		gui.showMessage(guiMessages[0]);
		amountOfPlayers = gui.getUserInteger(guiMessages[1], 2, 4);
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
			String playerName = gui.getUserString(guiMessages[2] + j + guiMessages[3] );
			Player player = new Player(playerName, startingMoney, 0);
			Players[i] = player;
			String color = gui.getUserButtonPressed(guiMessages[2] + j + guiMessages[4], guiMessages[5], guiMessages[6], guiMessages[7], guiMessages[8]);
			GUI_Car car = new GUI_Car();
			if (color == guiMessages[5]) {
				car.setPrimaryColor(Color.RED);
			}
			if (color == guiMessages[6]) {
				car.setPrimaryColor(Color.GREEN);
			}
			if (color == guiMessages[7]) {
				car.setPrimaryColor(Color.BLUE);
			}
			if (color == guiMessages[8]) {
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
	private void playerTurn(int cp, String[] guiMessage) {
		gui.showMessage( guiMessage[9]);
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
		String[] fieldText = Translater.file("Field.txt");
		String[] fieldSubtext = Translater.file("Fieldsubext.txt");
		String[] fieldRent = Translater.file("Rent.txt");
		

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