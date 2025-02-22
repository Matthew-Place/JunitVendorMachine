package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTest {
	Wallet wallet;

	@BeforeAll
	public static void beforeAll() {
	}

	@BeforeEach
	public void beforeEach() {
		wallet = new Wallet();
	}

	@Test
	void constructorInstanceTest1() {
		assertTrue(wallet instanceof Wallet);
	}

	@Test
	void constructorTest1() {
		String expected = "Generic";
		assertEquals(expected, wallet.getBrand());
	}
	
	@Test
	void constructorInstanceTest2() {
		float storedCredit = 20.0f;
		wallet = new Wallet(storedCredit);
		assertTrue(wallet instanceof Wallet);
	}

	@Test
	void constructorTest2() {
		String expected = "Generic";
		float storedCredit = 20.0f;
		wallet = new Wallet(storedCredit);
		assertEquals(expected, wallet.getBrand());
	}

	@Test
	void constructorTest3() {
		float expected = 20.0f;
		float storedCredit = 20.0f;
		wallet = new Wallet(storedCredit);
		assertEquals(expected, wallet.getAllCredit());
	}
	
	@Test
	void constructorInstanceTest3() {
		String brand = "Test";
		float storedCredit = 20.0f;
		wallet = new Wallet(brand, storedCredit);
		assertTrue(wallet instanceof Wallet);
	}

	@Test
	void constructorTest4() {
		String expected = "Test";
		String brand = "Test";
		float storedCredit = 20.0f;
		wallet = new Wallet(brand, storedCredit);
		assertEquals(expected, wallet.getBrand());
	}

	@Test
	void constructorTest5() {
		float expected = 20.0f;
		String brand = "Test";
		float storedCredit = 20.0f;
		wallet = new Wallet(brand, storedCredit);
		assertEquals(expected, wallet.getAllCredit());
	}

	@Test
	void addCreditTest() {
		float credit = 0.5f;
		float expected = 1.0f;
		wallet.addCredit(credit);
		assertEquals(expected, wallet.getAllCredit());
	}

	@Test
	void getCreditUnderTest1() {
		float credit = 0.5f;
		float expected = 0.5f;
		assertEquals(expected, wallet.getCredit(credit));
	}

	@Test
	void getCreditUnderTest2() {
		float credit = 0.5f;
		float expected = 0.0f;
		wallet.getCredit(credit);
		assertEquals(expected, wallet.getAllCredit());
	}

	@Test
	void getCreditTestOverTest1() {
		float credit = 0.6f;
		float expected = 0.0f;
		assertEquals(expected, wallet.getCredit(credit));
	}

	@Test
	void getCreditTestOverTest2() {
		float credit = 0.6f;
		float expected = 0.5f;
		wallet.getCredit(credit);
		assertEquals(expected, wallet.getAllCredit());
	}

	@Test
	void setCreditTest() {
		float credit = 0.6f;
		float expected = 0.6f;
		wallet.setCredit(credit);
		assertEquals(expected, wallet.getAllCredit());
	}

	@Test
	void setBrandTest() {
		String Brand = "Test";
		String expected = "Test";
		wallet.setBrand(Brand);
		assertEquals(expected, wallet.getBrand());
	}

	@AfterEach
	public void afterEach() {
	}

	@AfterAll
	public static void afterAll() {
	}
}
