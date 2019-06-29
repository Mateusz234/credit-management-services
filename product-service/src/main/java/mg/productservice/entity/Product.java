package mg.productservice.entity;

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
		this.creditId = creditId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
