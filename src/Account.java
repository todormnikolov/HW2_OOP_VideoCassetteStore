
public class Account {

	private int accountId;
	private String name;
	private static int id = 1;

	public Account(String name) {
		this.accountId = id++;
		setName(name);
	}

	public int getAccountId() {
		return accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals("")) {
			this.name = "Account " + this.getAccountId();
		} else {
			this.name = name;
		}
	}

	public void printInfo() {
		System.out.printf("%d - Name: %s\n", this.accountId, getName());
	}

}
