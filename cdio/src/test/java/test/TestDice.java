package test;


import static org.junit.Assert.*;
import cdio.DiceCup;
import cdio.Dice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDice {

	DiceCup dc = new DiceCup(1);

	Dice d1 = new Dice(0);


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDice() {

		for (int i = 0; i < 1000; i++) {
			dc.rollDiceCup();
			assertTrue("terning slår for højt", dc.getSum()<=6);
			assertTrue("terning slår for lavt", dc.getSum()>=1);
		}
	}

	@Test
	public final void testSum() {

		d1.setFaceValue(3);
		int i = d1.getFaceValue();
		assertEquals("message", 3, i);

	}
}
