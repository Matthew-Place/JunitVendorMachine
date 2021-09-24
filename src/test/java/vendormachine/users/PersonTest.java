package vendormachine.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.util.Wallet;

// Example 100% Person Test Coverage
// add @Ignore above class to help WalletTest.java
public class PersonTest {
	Person person;

	// Resources
	private float credit = 10.0f;
	private Wallet wallet = new Wallet();

	// Keep track of tests
	private static int activeTest = 1;
	private static StringBuilder sBuilder = new StringBuilder();
	private static String div = "=============================================\n";

	@BeforeEach
	public void beforeTest() {
		person = new Person("person");

		// Set Default test Wallet credit
		wallet.setCredit(credit);

		// Start of console test format
		sBuilder.setLength(0);
		sBuilder.append("\tTest ").append(activeTest).append("\n").append(div).append("Console:")
				.append("Starting Credit: ").append(wallet.getAllCredit()).append("\n");

		System.out.println(sBuilder.toString());
		activeTest++;
		// End of console test format
	}

	@Test
	void ConstructorInstanceTest1() {
		assertTrue(person instanceof Person);
	}

	@Test
	void ConstructorTest1() {
		String expected = "person";
		assertEquals(expected, person.getName());
	}

	@Test
	void ConstructorInstanceTest2() {
		person = new Person("Test", wallet);
		assertTrue(person instanceof Person);
	}

	@Test
	void ConstructorTest2() {
		person = new Person("Test", wallet);
		Wallet expected = wallet;
		assertEquals(expected, person.getWallet());
	}

	@Test
	void ConstructorTest3() {
		person = new Person("Test", wallet);
		String expected = "Test";
		assertEquals(expected, person.getName());
	}

	@Test
	void setNameTest() {
		person.setName("Test");
		String expected = "Test";
		assertEquals(expected, person.getName());
	}

	@Test
	void getWalletNullTest() {
		assertNull(person.getWallet());
	}

	@Test
	void setWalletTest() {
		person.setWallet(wallet);
		Wallet expected = wallet;
		assertEquals(expected, person.getWallet());
	}

	@Test
	void getCreditTest() {
		person.setWallet(wallet);
		float expected = 5.0f;
		float credit = person.getCredit(5.0f);
		assertEquals(expected, credit);
	}

	@Test
	void getCreditZeroTest1() {
		person.setWallet(wallet);
		float expected = 0f;
		float credit = person.getCredit(50.0f);
		assertEquals(expected, credit);
	}

	@Test
	void getCreditZeroTest2() {
		float expected = 0f;
		assertEquals(expected, person.getCredit(expected));
	}

	@Test
	void addCreditTest() {
		person.setWallet(wallet);
		person.addCredit(5.0f);
		float expected = 15.0f;
		assertEquals(expected, person.getCredit(15.0f));
	}

	@Test
	void addCreditNoWalletTest() {
		person.addCredit(5.0f);
		assertNull(person.getWallet());
	}

	@AfterEach
	public void afterTest() {
		System.out.println(div);
	}

}
