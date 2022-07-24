package model;


public class Account  {
	private int Id;
	private String Name;
	private String Pass;
	private int Points;
	private int BANK_Account;
	
	public Account() {}
	
	public Account(int Id, String Name, String Pass,
			int Points, int BANK_Account) {
		this.Id = Id;
		this.Name = Name;
		this.Pass = Pass;
		this.Points = Points;
		this.BANK_Account = BANK_Account;
	}
	public int getID() { return Id; }
	public String getNAME() { return Name; }
	public String getPASS() { return Pass; }
	public int getPOINTS() { return Points; }
	public int getBANK_ACCOUNT() { return BANK_Account; }
}



