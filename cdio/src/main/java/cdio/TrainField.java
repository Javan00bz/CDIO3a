package cdio;

import cdio.Player;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class TrainField extends Field{

	String[] guiMessages = Translater.file("Gamefunctions.txt");
	public TrainField(String nameOfField) {
		super(nameOfField);
	}
	
	public void landOnField(GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		gui.showMessage(guiMessages[15]);

	}

}