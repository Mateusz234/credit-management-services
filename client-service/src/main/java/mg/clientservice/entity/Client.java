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

}
