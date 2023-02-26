import java.util.HashMap;

public class ContactService {
	// Initialize a list for contacts and a variable for the current ID.
	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();

	// Search the list of contacts for ID, returns true if id is found and false if not.
	public boolean checkContact(String ID) {
		boolean answer = (contactList.containsKey(ID));
		return answer;
	}
	
	// The following method is used to search the list by ID and return the contact.
	public Contact getContact(String ID) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		Contact foundContact = (contactList.get(ID));
		return foundContact;
	}
	
	// The following method is used to add a contact to the list.
	public void addContact(String ID, String fName, String lName, String phone, String addr) {	
		if (checkContact(ID)) {
			throw new IllegalArgumentException("ID already exists.");
		}
		Contact contact = new Contact(ID, fName, lName, phone, addr);
		contactList.put(ID, contact);
	}
	
	// The following method is used to remove a contact from the list.
	public void removeContact(String ID) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		contactList.remove(ID);
	}
	
	// The following methods are used to update contacts' variables within the list.
	public void fNameUpdate(String ID, String newName) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		Contact newContact = new Contact(contactList.get(ID).getID(),newName,contactList.get(ID).getLName(),
				contactList.get(ID).getPhone(),contactList.get(ID).getAddress());
		removeContact(ID);
		contactList.put(ID, newContact);
	}
	public void lNameUpdate(String ID, String newName) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		Contact newContact = new Contact(contactList.get(ID).getID(),contactList.get(ID).getFName(),
				newName,contactList.get(ID).getPhone(),contactList.get(ID).getAddress());
		removeContact(ID);
		contactList.put(ID, newContact);
	}
	public void phoneUpdate(String ID, String newPhone) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		Contact newContact = new Contact(contactList.get(ID).getID(),contactList.get(ID).getFName(),
				contactList.get(ID).getLName(),newPhone,contactList.get(ID).getAddress());
		removeContact(ID);
		contactList.put(ID, newContact);
	}
	public void addressUpdate(String ID, String newAddr) {
		if (checkContact(ID) == false) {
			throw new IllegalArgumentException("ID not found in list.");
		}
		Contact newContact = new Contact(contactList.get(ID).getID(),contactList.get(ID).getFName(),
				contactList.get(ID).getLName(),contactList.get(ID).getPhone(),newAddr);
		removeContact(ID);
		contactList.put(ID, newContact);
	}
}