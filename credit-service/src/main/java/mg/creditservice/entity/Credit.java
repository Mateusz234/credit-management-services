package mg.creditservice.entity;

public class Credit {
	
	private int creditId;

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
}
