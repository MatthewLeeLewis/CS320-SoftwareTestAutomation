import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// First, test that contacts can be correctly added to the list
	@Test
	void testContactServiceAdd() {
		ContactService Contacts = new ContactService();
		assertTrue(Contacts.checkContact("1034512451") == (false));
		Contacts.addContact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		assertTrue(Contacts.checkContact("1034512451"));
	}
	
	// Second, test that contacts cannot be added with duplicate ID
	@Test
	void testContactServiceDuplicateID() {
		ContactService Contacts = new ContactService();
		Contacts.addContact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.addContact("1034512451", "Jane", "Doe", "7062535343", "120 Fake Road Ln, Fake City GA");
		});
	}
	
	// Third, test that contacts can be correctly removed from the list.
	@Test
	void testContactServiceRemoveContact() {
		ContactService Contacts = new ContactService();
		Contacts.addContact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		Contacts.removeContact("1034512451");
		assertTrue(Contacts.checkContact("1034512451") == (false));
	}
	
	// Fourth, test that contact update variables work.
	@Test
	void testContactUpdateVars() {
		ContactService Contacts = new ContactService();
		Contacts.addContact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		Contacts.fNameUpdate("1034512451", "Jane");
		Contacts.lNameUpdate("1034512451", "Foster");
		Contacts.phoneUpdate("1034512451", "6785262453");
		Contacts.addressUpdate("1034512451", "120 Aged Pine Circle");
		assertTrue(Contacts.getContact("1034512451").getFName() == "Jane");
		assertTrue(Contacts.getContact("1034512451").getLName() == "Foster");
		assertTrue(Contacts.getContact("1034512451").getPhone() == "6785262453");
		assertTrue(Contacts.getContact("1034512451").getAddress() == "120 Aged Pine Circle");
	}
	
	// Finally, test that exceptions are properly thrown when an ID isn't found.
	@Test
	void testContactServiceIdNotFound() {
		ContactService Contacts = new ContactService();
		Contacts.addContact("1034512451", "John", "Doe", "7708934268", "118 Fake Road Ln, Fake City GA");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.removeContact("1034512452");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.fNameUpdate("1034512452", "Jane");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.lNameUpdate("1034512452", "Foster");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.phoneUpdate("1034512452", "6785262453");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.addressUpdate("1034512452", "120 Aged Pine Circle");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contacts.getContact("1034512452").getFName();
		});
	}

}
