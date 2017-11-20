package cdio;
import cdio.Field;

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


}
