package cdio;

//Klasse for spillerens konto. En konto indeholder en integer
public class Account {
	   
	int value;
	
	public Account(int V)
	{
		value = V;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int newValue)
	{
		value=newValue;
	}
	//Tilføjer et antal point til en spillers konto
	public int deposit(int deposit)
	{
		return value = value + deposit;
	}
	//Hæver et antal point fra en spillers konto. Sørger for at kontoen aldrig kommer under 0
	public int withdraw(int withdrawal)
	{	
		value = value - withdrawal;
		if (value < 0)
			value = 0;
		return value;
	}
}
