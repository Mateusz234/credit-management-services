package mg.clientservice.entity;

public class Client {

	private String name, lastName, personalId;

	public Client() {
		
	}
	
	public Client(String name, String lastName, String personalId) {
		setName(name);
		setLastName(lastName);
		setPersonalId(personalId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	
	// convert char to ascii, uppercase have values 65-90
	// lowercase are 97-122
	private boolean hasFoundSpecialSignInString(String stringToCheck) {
		int cAscii;
		for(char c : stringToCheck.toCharArray()) {
			cAscii = (int) c;
			if(!((cAscii >= 65 && cAscii <= 90) || (cAscii >= 97 && cAscii <= 122)))
				return true;
		}
		return false;
	}
	
	// numbers in ascii have values 48-57
	private boolean hasFoundNotANumberInString(String stringToCheck) {
		int cAscii;
		for(char c : stringToCheck.toCharArray()) {
			cAscii = (int) c;
			if(!(cAscii >= 48 && cAscii <= 57))
				return true;
		}
		return false;
	}

}
