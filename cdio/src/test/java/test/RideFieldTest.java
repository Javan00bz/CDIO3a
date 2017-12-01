package test;


import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.awt.Color;

import javax.naming.ldap.StartTlsRequest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cdio.DiceCup;
import cdio.Field;
import cdio.Game;
import cdio.GameBoard;
import cdio.Player;
import cdio.PrisonField;
import cdio.RideField;
import cdio.SpecialField;
import cdio.Translater;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class RideFieldTest {

	public GUI gui = new GUI(startgui());

	private static GameBoard board = new GameBoard(GameBoard.generateGameFields());
	
	
	Player o = new Player("Oliver", 200, 0);
	Player y = new Player("Yoss", 200, 0);

	GUI_Player gpo = new GUI_Player(o.getName(), o.getAccount().getValue());
	GUI_Player gpy = new GUI_Player(y.getName(), y.getAccount().getValue());
	
	RideField rf = new RideField("a", 2, 2, o);
	RideField rf1 = new RideField("b", 3, 4, y);
	GUI_Street gs = new GUI_Street();


	@Before
	public void setUp() throws Exception {
//		
//		Field[] fields;
//		for (int i = 0; i < 24; i++) {
//			GUI_Street gui_street = new GUI_Street();
//			gui_street.setTitle("Title");
//			gui_street.setSubText("Subtext");
//			gui_street.setRent("2");
//			gui_street.setDescription("Description");
//			fields[i] = gui_street;
//		}

	}


	private GUI_Field[] startgui() {
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

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLandOnField() {
		o.setPosition(3);
		board.fields[3].landOnField(gui, gs, o, gpo);
		}


	

	@Test
	public final void testGetPrice() {
		assertTrue(rf1.getPrice()==4);
	}

	@Test
	public final void testSetPrice() {
		rf1.setPrice(1);
		assertTrue(rf1.getPrice()==1);
	}

	@Test
	public final void testSetOwner() {
		rf1.setOwner(o);
		assertTrue(rf.getOwner()==o);
	}



	@Test
	public final void testGetNameOfField() {
		assertTrue("START"==gui.getFields()[0].getTitle());
	}

	@Test
	public final void testSetNameOfField() {
		gui.getFields()[0].setTitle("hej");
		//assertTrue(gui.getFields()[0].getTitle()=="hej");
		assertEquals("set name error", "hej", gui.getFields()[0].getTitle());
	}


	
}
