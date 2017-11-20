package cdio;

public class Field {
	String nameOfField;
	int fieldNumber;
	String fieldType;

	public Field(String nameOfField, int fieldNumber, String fieldType) {
		this.nameOfField = nameOfField;
		this.fieldNumber = fieldNumber;
		this.fieldType = fieldType;
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