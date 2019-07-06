package mg.creditservice.entity;

public class Product {

	private int creditId;
	private String name;
	private double value;

	public Product() {

	}

	public Product(int creditId, String name, double value) {
		setCreditId(creditId);
		setName(name);
		setValue(value);
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		if (value < 0)
			throw new IllegalArgumentException("Product value cannot be negative!");
		if (value == 0)
			throw new IllegalArgumentException("Product value cannot be zero!");
		this.value = value;
	}

	// convert char to ascii, uppercase have values '65-90'
	// lowercase are '97-122'
	// allow only white spaces '32'
	private boolean hasFoundSpecialSignInString(String stringToCheck) {
		int cAscii;
		for (char c : stringToCheck.toCharArray()) {
			cAscii = (int) c;
			if (!((cAscii >= 65 && cAscii <= 90) || (cAscii >= 97 && cAscii <= 122)))
				if (cAscii == 32)
					continue; // if special letter is space - allow it
				else
					return true;
		}
		return false;
	}

}
