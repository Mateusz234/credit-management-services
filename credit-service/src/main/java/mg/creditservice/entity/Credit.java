package mg.creditservice.entity;

public class Credit {
	
	private int creditId;
	private Customer customer;
	private Product product;

	public Credit() {
		
	}
	
	public Credit(int creditId) {
		setCreditId(creditId);
	}

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		if (creditId < 0)
			throw new IllegalArgumentException("Credit ID must be a positive number!");
		this.creditId = creditId;
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
	
	//TODO remove it later
	@Override
	public String toString() {
		return("" + creditId);
	}
}
