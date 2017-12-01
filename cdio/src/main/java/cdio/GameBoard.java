package cdio;

import cdio.Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import cdio.Game;

public class GameBoard {

	public Field[] fields;

	public GameBoard(Field[] fields) {
		this.fields = fields;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public void resolveField(Field f, GUI gui, GUI_Street street, Player pl, GUI_Player Gpl) {
		f.landOnField(gui, street, pl, Gpl);
	}

	public static Field[] generateGameFields() {
		String[] fieldText = Translater.file("Fields.txt");
		Field[] fields = new Field[24];
		fields[0] = new SpecialField(null, 0,0);
		fields[1] = new RideField(null, 1, 1, null);
		fields[2] = new RideField(null,2, 1, null);
		fields[3] = new SpecialField(null, 3, 0);
		fields[4] = new RideField(null, 4, 1, null);
		fields[5] = new RideField(null, 5, 1, null);
		fields[6] = new SpecialField(null, 6, 0);
		fields[7] = new RideField(null, 7, 2, null);
		fields[8] = new RideField(null, 8, 2, null);
		fields[9] = new SpecialField(null, 9, 2);
		fields[10] = new RideField(null, 10, 2, null);
		fields[11] = new RideField(null, 11, 2, null);
		fields[12] = new SpecialField(null, 12, 0);
		fields[13] = new RideField(null, 13, 3, null);
		fields[14] = new RideField(null, 14, 3, null);
		fields[15] = new SpecialField(null, 15, 0); 
		fields[16] = new RideField(null, 16, 3, null);
		fields[17] = new RideField(null, 17, 3, null);
		fields[18] = new PrisonField(null, 18, 0); 
		fields[19] = new RideField(null, 19, 4, null);
		fields[20] = new RideField(null, 20, 4, null);
		fields[21] = new SpecialField(null, 21, 2);
		fields[22] = new RideField(null, 22, 5, null);
		fields[23] = new RideField(null, 23, 5, null);

		for(int i = 0; i < fields.length; i++)
			fields[i].setNameOfField(fieldText[i]);
		return fields;
	}

	public static boolean sameOwner(GameBoard board, int field) {
		if (board.getFields()[field].getFieldNumber()!=23) {
			if (board.getFields()[field+1].getOwner() != null) {
				if (board.getFields()[field+1].getOwner().equals(board.getFields()[field].getOwner()))
					return true;}
			if (board.getFields()[field-1].getOwner() != null) {
				if (board.getFields()[field-1].getOwner().equals(board.getFields()[field].getOwner()))
					return true;}
		}

		return false;

	}

}


