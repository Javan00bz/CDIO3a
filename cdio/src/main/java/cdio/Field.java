package cdio;

public class Field {
	String nameOfField;
	int fieldNumber;
	String fieldType;
	boolean buyable;

	public Field(String nameOfField, int fieldNumber, String fieldType, boolean buyable) {
		this.nameOfField = nameOfField;
		this.fieldNumber = fieldNumber;
		this.fieldType = fieldType;
		this.buyable = buyable;
	}

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public int getFieldNumber() {
		return fieldNumber;
	}

	public boolean getBuyable() {
		return buyable;
	}
	
	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
		
	}
	
	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}


}