package test;


import static org.junit.Assert.*;
import cdio.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	Account a = new Account(200);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetValue() {
		int actual = a.getValue();
		assertEquals(200, actual);
	}

	@Test
	public final void testSetValue() {
		a.setValue(220);
		assertEquals(220, a.getValue());
	}

	@Test
	public final void testDeposit() {
		a.deposit(50);
		assertEquals(250, a.getValue());
	}

	@Test
	public final void testWithdraw() {
		a.withdraw(80);
		assertEquals(120, a.getValue());
	}
}