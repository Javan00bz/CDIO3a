package cdio;

import java.awt.Color;
import cdio.Player;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Game {

	public GUI gui = new GUI(generateFields()); //Laver en ny GUI, og bruger generateFields metoden til at definiere felter.
	private static GameBoard board = new GameBoard(GameBoard.generateGameFields());
	private Player[] Players; //Laver et array som senere bliver fyldt med spillere
	private GUI_Player[] GUI_Players; //Laver et array som senere bliver fyldt med GUI_Spillere
	private int startingMoney;
	private DiceCup cup = new DiceCup(1); //Laver et raflebæger med en terning
	private int amountOfPlayers;
	String[] guiMessages = Translater.file("Gamefunctions.txt"); //String Array der indeholder alle beskeder i spillet
	private boolean winner = false;
	public static void main(String[] args) {
		new Game().playGame();
	}

	private void playGame(){
		startGame();
		for(int i = 0; i<amountOfPlayers; i++) {
			playerTurn(Players[i], GUI_Players[i]);
			if (i == amountOfPlayers-1)
				i=-1;
			if (winner==true)
				break;}
	}

	private void startGame() {
		gui.showMessage(guiMessages[0]);
		amountOfPlayers = gui.getUserInteger(guiMessages[1], 2, 4); //Får at vide hvor mange spillere der skal være i spillet
		switch (amountOfPlayers) { //Sætter startingMoney afhængig af hvor mange spillere der er
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
		for(int i=0; i < amountOfPlayers; i++) { //Loop der laver alle spillere, GUI_Spillere og biler
			j++;
			String playerName = gui.getUserString(guiMessages[2] + j + guiMessages[3] );
			for(int k=i-1; k>=0; k--) { //Loop der checker om 2 spillere hedder det samme
				while(Players[k].getName().equals(playerName))
				{
					playerName = gui.getUserString("You cant have the same name as another player. Please try again");
					k=i-1;
				}
			}
			Player player = new Player(playerName, startingMoney, 0); 
			Players[i] = player;
			String color = gui.getUserButtonPressed(guiMessages[2] + j + guiMessages[4], guiMessages[5], guiMessages[6], guiMessages[7], guiMessages[8]);
			GUI_Car car = new GUI_Car(); //Laver en ny bil og sætter dens farve afhængig af en spilers input
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
			for(int k=i-1; k>=0; k--) { //Checker om 2 biler har samme farve
				while(GUI_Players[k].getCar().getPrimaryColor().equals(car.getPrimaryColor()))
				{
					color = gui.getUserButtonPressed("Your car has the same color as another players. Please pick a different color", guiMessages[5], guiMessages[6], guiMessages[7], guiMessages[8]);
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
					k=i-1;
				}
			}
			GUI_Player Gui_Player = new GUI_Player(Players[i].getName(), Players[i].getAccount().getValue(), car);
			GUI_Players[i] = Gui_Player;
			gui.addPlayer(GUI_Players[i]);
			gui.getFields()[Players[i].getPosition()].setCar(GUI_Players[i], true);
		}
		this.Players = Players;
		this.GUI_Players = GUI_Players;

	}
	private void playerTurn(Player p, GUI_Player gp) {
		gui.showMessage("" + p.getName() + guiMessages[9]);
		cup.rollDiceCup();
		gui.setDie(cup.getDice()[0].getFaceValue());
		gui.getFields()[p.getPosition()].setCar(gp, false); //Fjerner spillerens biler fra pladen
		p.setPosition(p.getPosition() + cup.getDice()[0].getFaceValue());
		if (p.getPosition()<24)
			gui.getFields()[p.getPosition()].setCar(gp, true); //Sætter bilen på pladen igen
		else { //Hvis bilen er nået rundt om brættet, trækkes 24 fra spillerens position
			p.setPosition(p.getPosition()-24);
			p.getAccount().deposit(2);
			gp.setBalance(p.getAccount().getValue());
			gui.getFields()[p.getPosition()].setCar(gp, true);
		}
		getBoard().resolveField(getBoard().getFields()[p.getPosition()], gui, (GUI_Street) gui.getFields()[p.getPosition()], p, gp); //Laaaaaaang metode der styrer hvad der skal ske på feltet
		for (int i = 0; i < Players.length; i++) {
			GUI_Players[i].setBalance(Players[i].getAccount().getValue());
		}
		if (p.getAccount().getValue()<=0) { //Slutter spillet hvis en spiller har 0 penge
			endGame();
		}
		if(p.getPosition() == 3 || p.getPosition() == 15) //Giver spilleren en ekstratur hvis de lander på et train felt
			playerTurn(p, gp);	
	}


	private GUI_Field[] generateFields() {
		String[] fieldText = Translater.file("Fields.txt");
		String[] fieldSubtext = Translater.file("Fieldsubtext.txt");
		String[] fieldRent = Translater.file("Rent.txt");


		GUI_Field[] fields = new GUI_Field[24];
		for (int i = 0; i < fields.length; i++) {
			GUI_Street gui_street = new GUI_Street();
			gui_street.setTitle(fieldText[i]);
			gui_street.setSubText(fieldSubtext[i]);
			gui_street.setRent(fieldRent[i]);
			gui_street.setDescription(fieldText[i]);
			fields[i] = gui_street;
		}
		fields[1].setBackGroundColor(Color.red);
		fields[2].setBackGroundColor(Color.red);
		fields[4].setBackGroundColor(Color.cyan);
		fields[5].setBackGroundColor(Color.cyan);
		fields[7].setBackGroundColor(Color.PINK);
		fields[8].setBackGroundColor(Color.PINK);
		fields[10].setBackGroundColor(Color.BLUE);
		fields[11].setBackGroundColor(Color.BLUE);
		fields[13].setBackGroundColor(Color.WHITE);
		fields[14].setBackGroundColor(Color.WHITE);
		fields[16].setBackGroundColor(Color.DARK_GRAY);
		fields[17].setBackGroundColor(Color.DARK_GRAY);
		fields[19].setBackGroundColor(Color.MAGENTA);
		fields[20].setBackGroundColor(Color.MAGENTA);
		fields[22].setBackGroundColor(Color.ORANGE);
		fields[23].setBackGroundColor(Color.ORANGE);
		return fields;
	}

	private void endGame() { // Når playgame loop slutter, findes vinder ved højeste værdi.
		Player winner = new Player(null, 0, 0);
		for (int i=0; i<Players.length; i++) { //Finder spilleren med den højeste balances
			if (Players[i].getAccount().getValue()>winner.getAccount().getValue());
			winner=Players[i];
		}
		this.winner = true;
		gui.showMessage(guiMessages[13] + winner.getName()+ guiMessages[14]);
	}

	public static GameBoard getBoard() {
		return board;
	}

	public static void setBoard(GameBoard board) {
		Game.board = board;
	}

}