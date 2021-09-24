package vendormachine.vendors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.vendors.item.Snack;

public class SnackTest {
	Snack snack;
	float credit = 5f;

	@BeforeAll
	public static void beforeAll() {
	}

	@BeforeEach
	public void beforeEach() {
		snack = new Snack(credit);
	}

	@Test
	void ConstructorInstanceTest1() {
		assertTrue(snack instanceof Snack);
	}

	@Test
	void ConstructorTest1() {
		float expected = 5f;
		assertEquals(expected, snack.cost());
	}

	@Test
	void ConstructorInstanceTest2() {
		snack = new Snack("Test", credit);
		assertTrue(snack instanceof Snack);
	}

	@Test
	void ConstructorTest2() {
		snack = new Snack("Test", credit);
		String expected = "Test";
		assertEquals(expected, snack.name);
	}
	
	@Test
	void setPriceTest() {
		snack.setValue(10f);
		float expected = 10f;
		assertEquals(expected, snack.cost());
	}

	@AfterEach
	public void afterEach() {
	}

	@AfterAll
	public static void afterAll() {
	}
}
