
public class Store {

	private Account[] accounts;
	private VideoCassette[] videocassettes;

	public Store() {
		this.accounts = null;
		this.videocassettes = null;
	}

	public int searchAccount(int accId) {
		if (this.accounts != null) {

			int length = this.accounts.length;

			for (int i = 0; i < length; i++) {
				if (this.accounts[i].getAccountId() == accId) {
					return i;
				}
			}
		}

		return -1;
	}

	public int searchVideoCassette(int vcId) {
		if (this.videocassettes != null) {

			int length = this.videocassettes.length;

			for (int i = 0; i < length; i++) {
				if (this.videocassettes[i].getCassetteId() == vcId) {
					return i;
				}
			}
		}

		return -1;
	}

	public void addAccount(String name) {

		Account accNew = new Account(name);
		int length = 0;

		if (this.accounts != null) {
			length = this.accounts.length;
		}

		Account[] accTemp = new Account[length + 1];

		for (int i = 0; i < length; i++) {
			accTemp[i] = this.accounts[i];
		}

		accTemp[length] = accNew;

		this.accounts = accTemp;

	}

	public void addVideoCassette(String title) {

		VideoCassette vcNew = new VideoCassette(title);
		int length = 0;

		if (this.videocassettes != null) {
			length = this.videocassettes.length;
		}

		VideoCassette[] vcTemp = new VideoCassette[length + 1];

		for (int i = 0; i < length; i++) {
			vcTemp[i] = this.videocassettes[i];
		}

		vcTemp[length] = vcNew;

		this.videocassettes = vcTemp;

	}

	public void addVideoCassette() {
		System.out.println("addVideoCassette method start");
	}

	public void takeVideoCassette(int accIndex, int vcIndex) {
		if (!this.videocassettes[vcIndex].isReturned()) {
			System.out.println("The video cassette is already taken");
		} else {
			this.videocassettes[vcIndex] = this.videocassettes[vcIndex].getVideoCassette(this.accounts[accIndex]);
			System.out.println(
					"The video cassette is now taken by account with ID=" + this.accounts[accIndex].getAccountId());
		}
	}

	public void returnVideoCassette(int accIndex, int vcIndex) {

		if (this.videocassettes[vcIndex].isReturned()) {
			System.out.println("The video cassette is not taken");
		} else {
			this.videocassettes[vcIndex] = this.videocassettes[vcIndex].returnVideoCassette(this.accounts[accIndex]);
			System.out.println(
					"The video cassette is returned by account with ID=" + this.accounts[accIndex].getAccountId());
		}
	}

	public void showAccounts() {

		if (this.accounts == null) {
			System.out.println("No available records for accounts");
		} else {

			int length = this.accounts.length;
			int accId = 0;
			for (int i = 0; i < length; i++) {
				this.accounts[i].printInfo();
				if (this.videocassettes != null) {
					accId = this.accounts[i].getAccountId();
					for (int j = 0; j < this.videocassettes.length; j++) {
						if (accId == this.videocassettes[j].getTakenBy()) {
							this.videocassettes[j].printInfo();
						}
					}

				}
			}
		}
	}

	public void showNotReturned() {
		if (this.videocassettes == null) {
			System.out.println("No video cassettes in store");
		} else {
			int length = this.videocassettes.length;
			for (int i = 0; i < length; i++) {
				if (!this.videocassettes[i].isReturned()) {
					this.videocassettes[i].printInfoWithAccountId();
				}
			}
		}

	}

}
