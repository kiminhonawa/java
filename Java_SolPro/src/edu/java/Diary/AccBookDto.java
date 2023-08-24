package edu.java.Diary;

public class AccBookDto {
	 private String name;
	 private String type;
	 private double amount;

	public AccBookDto(String name, String type, double amount) {
		super();
		this.name = name;
		this.type = type;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "Transaction [name=" + name + ", type=" + type + ", amount=" + amount + "]";
	}
}
