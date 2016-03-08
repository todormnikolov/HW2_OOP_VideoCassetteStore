
public class Store {

	private Account[] acc;
	private VideoCassette[] vc;

	public Store() {
		this.acc = null;
		this.vc = null;
	}

	public void addAccount(String name) {

		Account accNew = new Account(name);
		int length = 0;

		if (this.acc != null) {
			length = this.acc.length;
		}

		Account[] accTemp = new Account[length + 1];

		for (int i = 0; i < length; i++) {
			accTemp[i] = this.acc[i];
		}

		accTemp[length] = accNew;

		this.acc = accTemp;

	}

	public void addVideoCassette() {
		System.out.println("addVideoCassette method start");
	}

	public void getVideoCassette() {
		System.out.println("getVideoCassette method start");
	}

	public void returnVideoCassette() {

		System.out.println("returnVideoCassette method start");
	}

	public void showAccounts() {

		int length = this.acc.length;

		if (length == 0) {
			System.out.println("No aveable records for accounts");
		} else {
			for (int i = 0; i < length; i++) {
				this.acc[i].printInfo();
			}
		}
	}

	public void showNotReturned() {
		System.out.println("showNotReturned method start");

	}

}
