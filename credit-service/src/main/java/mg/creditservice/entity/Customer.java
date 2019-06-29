package mg.creditservice.entity;

public class Customer {

	private int creditId;
	private String name, lastName, personalId;

	public Customer() {

	}

	public Customer(int creditId, String name, String lastName, String personalId) {
		setCreditId(creditId);
		setName(name);
		setLastName(lastName);
		setPersonalId(personalId);
	}

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		if (creditId < 0)
			throw new IllegalArgumentException("Credit ID must be a positive number!");
		this.creditId = creditId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Name connot be null!");
		if (name == "")
			throw new IllegalArgumentException("Name cannot be empty!");
		if (hasFoundSpecialSignInString(name))
			throw new IllegalArgumentException("Special signs and numbers are not allowed in name!");
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null)
			throw new IllegalArgumentException("Last name connot be null!");
		if (lastName == "")
			throw new IllegalArgumentException("Last name cannot be empty!");
		if (hasFoundSpecialSignInString(lastName))
			throw new IllegalArgumentException("Special signs and numbers are not allowed in last name!");

		this.lastName = lastName;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		if (personalId == null)
			throw new IllegalArgumentException("Personal ID connot be null!");
		if (personalId == "")
			throw new IllegalArgumentException("Personal ID cannot be empty!");
		if (personalId.length() != 11)
			throw new IllegalArgumentException("personal ID must have exactly 11 numbers!");
		if(hasFoundNotANumberInString(personalId))
			throw new IllegalArgumentException("Special signs and letters are not allowed in personal ID!");
		this.personalId = personalId;
	}

	// convert char to ascii, uppercase have values 65-90
	// lowercase are 97-122
	private boolean hasFoundSpecialSignInString(String stringToCheck) {
		int cAscii;
		for (char c : stringToCheck.toCharArray()) {
			cAscii = (int) c;
			if (!((cAscii >= 65 && cAscii <= 90) || (cAscii >= 97 && cAscii <= 122)))
				return true;
		}
		return false;
	}

	// numbers in ascii have values 48-57
	private boolean hasFoundNotANumberInString(String stringToCheck) {
		int cAscii;
		for (char c : stringToCheck.toCharArray()) {
			cAscii = (int) c;
			if (!(cAscii >= 48 && cAscii <= 57))
				return true;
		}
		return false;
	}

}
