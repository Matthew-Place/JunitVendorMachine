package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTest {
	DrinkVendingMachine vender;

	@BeforeAll
	public static void beforeAll() {
	}

	@BeforeEach
	public void beforeEach() {
		vender = new DrinkVendingMachine();
	}

	@Test
	void constructorInstanceTest1() {
		assertTrue(vender instanceof DrinkVendingMachine);
	}

	@Test
	void constructorTest1() {
		float expected = 0f;
		assertEquals(expected, vender.getAvailableCredit());
	}

	@Test
	void constructorTest2() {
		BRANDS expected = BRANDS.CaramelSprinkle;
		assertEquals(expected, vender.getBrandName());
	}

	@Test
	void constructorInstanceTest2() {
		BRANDS brandName = BRANDS.EnergyMax;
		float availableCredit = 100f;
		vender = new DrinkVendingMachine(availableCredit, brandName);
		assertTrue(vender instanceof DrinkVendingMachine);
	}

	@Test
	void constructorTest3() {
		BRANDS brandName = BRANDS.EnergyMax;
		float availableCredit = 100f;
		BRANDS expected = BRANDS.EnergyMax;
		vender = new DrinkVendingMachine(availableCredit, brandName);
		assertEquals(expected, vender.getBrandName());
	}

	@Test
	void constructorTest4() {
		BRANDS brandName = BRANDS.EnergyMax;
		float availableCredit = 100f;
		float expected = 100f;
		vender = new DrinkVendingMachine(availableCredit, brandName);
		assertEquals(expected, vender.getAvailableCredit());
	}

	@Test
	void selectDrinkInsufficientFundsTest() {
		assertNull(vender.selectDrink(1));
	}

	@Test
	void selectDrinkSelectionTest() {
		BRANDS brandName = BRANDS.EnergyMax;
		float availableCredit = 100f;
		String expected = "VanillaBurst";
		vender = new DrinkVendingMachine(availableCredit, brandName);
		Snack snack = vender.selectDrink(1);
		assertEquals(expected, snack.name);
	}

	@Test
	void selectDrinkSelectionCreditTest() {
		BRANDS brandName = BRANDS.EnergyMax;
		float availableCredit = 100f;
		float expected = 1.75f;
		vender = new DrinkVendingMachine(availableCredit, brandName);
		Snack snack = vender.selectDrink(1);
		assertEquals(expected, snack.cost());
	}

	@Test
	void selectDrinkSelectionLessThanZeroTest() {
		assertNull(vender.selectDrink(-1));
	}

	@Test
	void selectDrinkSelectionOverTest() {
		assertNull(vender.selectDrink(DefaultSnacks.snackList.length));
	}

	@Test
	void giveCreditTest() {
		Wallet wallet = new Wallet(1f);
		Person user = new Person("Test", wallet);
		float expected = 1f;
		vender.giveCredit(user, 1f);
		assertEquals(expected, vender.getAvailableCredit());
	}

	@AfterEach
	public void afterEach() {
	}

	@AfterAll
	public static void afterAll() {
	}
}
