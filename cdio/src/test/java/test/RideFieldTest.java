package test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cdio.Player;
import cdio.RideField;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class RideFieldTest {

	
	Player o = new Player("Oliver", 200, 0);
	Player y = new Player("Yoss", 200, 0);
	RideField rf= new RideField("Rutchebane", 5, 5, o);
	RideField rf1 = new RideField("rutschebane 1", 1, 4, null);
	GUI_Player gpo = new GUI_Player(o.getName(), o.getAccount().getValue());
	GUI_Player gpy = new GUI_Player(y.getName(), y.getAccount().getValue());
	GUI gui = new GUI();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLandOnField() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetOwner() {
		assertTrue(rf.getOwner()==o);
	}

	@Test
	public final void testRideField() {
		fail("Not yet implemented"); // TODO
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
		assertTrue(rf.getOwner()==rf1.getOwner());

	}

	@Test
	public final void testPayRent() {

		
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testBuyField() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testField() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetNameOfField() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetNameOfField() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetFieldNumber() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetFieldNumber() {
		fail("Not yet implemented"); // TODO
	}

}
