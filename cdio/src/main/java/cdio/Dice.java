package cdio;

public class Dice {
	
	private int faceValue;
	
	public Dice (int value){
		value = faceValue;
	}
	public int rollDice() {
		faceValue = (int)(Math.random()*6+1);
		return faceValue;
	}
	public int getFaceValue(){
		return faceValue;
	}
	public int setFaceValue(int newFaceValue) {
		faceValue = newFaceValue;
		return faceValue;
	}

}
