package cdio;

import gui_fields.GUI_Field;
import gui_main.GUI;

public class Fields {
	
	public static FieldAction fængsel = new FieldAction()
	{
		public void action(Player player, Player[] players, GUI_Field field, GUI gui) {
			//Define function of fængsel field
		}
	};
	
	public static FieldAction chance = new FieldAction()
	{
		public void action(Player player, Player[] players, GUI_Field field, GUI gui) {
			
		}
	};
	
	public static FieldAction empty = new FieldAction()
	{
		public void action(Player player, Player[] players, GUI_Field field, GUI gui) {
			
		}
	};
	
	
	public static interface FieldAction
	{
		public void action(Player player, Player[] players, GUI_Field field, GUI gui);
	}
	
}
