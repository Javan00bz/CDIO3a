package test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cdio.Player;

public class PlayerTest { 
	
	Player p = new Player("Oliver", 300, 0);
	Player y = new Player("Yoss", 230, 5);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public final void testGetName() {
		assertTrue(p.getName()=="Oliver");
	}

	@Test
	public final void testSetName() {
		p.setName("Alexander");
		assertTrue(p.getName()=="Alexander");
	}

	@Test
	public final void testGetPosition() {
		assertTrue(p.getPosition()==0);
	}

	@Test
	public final void testSetPosition() {
		p.setPosition(5);
		assertTrue(5==p.getPosition());
	}

	@Test
	public final void testGetAccount() {
		assertTrue(p.getAccount().getValue()==300);
	}

	@Test
	public final void testSetAccount() {
		y.setAccount(p.getAccount());
		assertTrue(y.getAccount().getValue()==300);		
	}
}
