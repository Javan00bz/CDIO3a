package cdio;

import java.awt.Color;

import javax.print.attribute.HashPrintServiceAttributeSet;

import gui_fields.GUI_Car;
import gui_fields.GUI_Empty;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Main {

	private GUI gui = new GUI();
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
		new Main().playGame();
	}

	private void playGame(){
		startGame();
		for(int i = 0; i<amountOfPlayers; i++) {
			playerTurn(Players[i], GUI_Players[i]);
			if (i == amountOfPlayers-1)
				i=-1;}
	}

	public void startGame() {
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
			String playerName = gui.getUserString("Player " + j + " Enter your name" );
			Players[i] = new Player(playerName, startingMoney, 0);
			GUI_Cars[i] = new GUI_Car(); 
			GUI_Players[i] = new GUI_Player(Players[i].getName(), Players[i].getAccount().getValue(), GUI_Cars[i]);
			gui.addPlayer(GUI_Players[i]);
			gui.getFields()[Players[i].getPosition()].setCar(GUI_Players[i], true);
		}

	}
	public void playerTurn(Player Pl, GUI_Player Gpl) {
		gui.showMessage("click to roll");
		cup.rollDiceCup();
		gui.setDice(cup.getDice()[0].getFaceValue(), 4, 4, 10, cup.getDice()[0].getFaceValue(), 4, 4, 10);
		gui.getFields()[Pl.getPosition()].setCar(Gpl, false);
		Pl.setPosition(Pl.getPosition() + cup.getDice()[0].getFaceValue());
		if (Pl.getPosition()<24)
			gui.getFields()[Pl.getPosition()].setCar(Gpl, true);
		else {
			Pl.setPosition(Pl.getPosition()-24);
			gui.getFields()[Pl.getPosition()].setCar(Gpl, true);
		}

	}

	private void initializeGUI() {


		GUI_Field [] fields = new GUI_Field[40];

		for (int i = 0; i < 25; i++) {
			fields[i] = new GUI_Street();
			fields[i].setTitle("title1");
		}
		// Lav tomme felter som ikke skal bruges
		for (int i = 25; i < fields.length; i++) {
			fields[i] = new GUI_Empty();

		}


	}

}