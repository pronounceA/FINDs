package model;

public class AccountBeans {
	private int id;
	private String name;
	private String pass;
	private int points;
	private int bankAccount;
	
	
	public AccountBeans() {}
	
	public AccountBeans(String name, String pass, int points, int bankAccount) {
		super();
		
		this.name = name;
		this.pass = pass;
		this.points = points;
		this.bankAccount = bankAccount;
	}
	
	public AccountBeans(int id, String name, String pass, int points, int bankAccount) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.points = points;
		this.bankAccount = bankAccount;
	}


	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
