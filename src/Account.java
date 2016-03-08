
public class Account {

	private int accountId;
	private String name;
	private static int id = 1;
	
	public Account(String name){
		this.accountId = id++;
		setName(name);
	}

	public int getAccountId() {
		return accountId;
	}

//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo(){
		System.out.printf("%d\t%s\n", this.accountId, getName());
	}
	
}
