package mg.creditservice.entity;

public class Credit {

	private int creditId;
	private String name;
	private Customer customer;
	private Product product;

	public Credit() {

	}

	public Credit(int creditId, String name) {
		setCreditId(creditId);
		setName(name);
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Override
	public String toString() {
		return "Credit [creditId=" + creditId + ", name=" + name + ", customer=" + customer + ", product=" + product
				+ "]";
	}

	// TODO override toString and build new string with fields needed

}
