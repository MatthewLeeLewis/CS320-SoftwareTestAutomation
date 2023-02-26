public class Contact {
	// Declares variables for the class.
	String uniqueID; 
	String firstName;
	String lastName;
	String phone;
	String address;
	
	// Constructor method
	public Contact(String ID, String fName, String lName, String numPhone, String addr) { 
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (numPhone == null || numPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (addr == null || addr.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		uniqueID = ID;
		firstName = fName;
		lastName = lName;
		phone = numPhone; 
		address = addr;
	}
	
	// The following methods are for getting a contact's variables and returning them.
	public String getID() {
		return uniqueID;
	}
	public String getFName() {
		return firstName;
	}
	public String getLName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
}