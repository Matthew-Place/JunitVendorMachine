package vendormachine.vendors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultSnacksTest {
	DefaultSnacks defaultSnacks;
	
	@BeforeAll
	public static void beforeAll() {
	}

	@BeforeEach
	public void beforeEach() {
		defaultSnacks = new DefaultSnacks();
	}
	
	@Test
	void ConstructorInstanceTest() {
		assertTrue(defaultSnacks instanceof DefaultSnacks);
	}

	@AfterEach
	public void afterEach() {
	}

	@AfterAll
	public static void afterAll() {
	}
}
