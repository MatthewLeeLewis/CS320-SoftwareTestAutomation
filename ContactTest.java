
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	// First, test that the contact can be correctly created with correctly entered valid arguments assigned to the correct variables.
	@Test
	void testContactClass() {
		Contact Contact = new Contact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		assertTrue(Contact.getID().equals("1034512451"));
		assertTrue(Contact.getFName().equals("John"));
		assertTrue(Contact.getLName().equals("Doe"));
		assertTrue(Contact.getPhone().equals("7708934268"));
		assertTrue(Contact.getAddress().equals("118 Fake Road Ln, Fake City GA"));
	}
	
	// Second, test that the variables cannot be too long, and that the exceptions are correctly thrown.
	@Test
	void testContactClassVarsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10345124511", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "Bartholomew", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Blankenship", "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Doe", "77089342688", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Doe", "7708934268", "1118 Fake Road Ln, Fake City GA");
		});
		//Also test that the phone number can't be too short...
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Doe", "770893426", "118 Fake Road Ln, Fake City GA");
		});
	}
	
	//Thirdly, test that none of the variables can be null
	@Test
	void testContactClassVarsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", null, "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", null, "7708934268", "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Doe", null, "118 Fake Road Ln, Fake City GA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1034512451", "John", "Doe", "7708934268", null);
		});
	}
}
