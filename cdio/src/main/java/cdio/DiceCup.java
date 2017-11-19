package cdio;
import cdio.Dice;

public class DiceCup {
	private Dice[] dice;

	public DiceCup(int i) {
		dice = new Dice[i];
		for (int j = 0; j < dice.length; j++) {
			dice[j] = new Dice(6);
		}
	}
	
	public void rollDiceCup() {
		for (int i = 0; i < dice.length; i++) {
			dice[i].rollDice();
		}
	}
	
	public Dice[] getDiceCup() {
		return dice;
	}
	
	public void setDice(Dice[] dice) {
		this.dice = dice;
	}
	
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < dice.length; i++) {
			sum =+ dice[i].getFaceValue();
		}
		return sum;
	}
}
