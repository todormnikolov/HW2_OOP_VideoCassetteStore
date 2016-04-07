import java.util.Scanner;

public class StoreDemo {

	private static Scanner sc = new Scanner(System.in);;

	public static void main(String[] args) {

		Store store = new Store();
		while (true) {
			int ch = menu();
			if (ch == 0) {
				System.out.println("Exit from system");
				break;
			}
			optionsExecute(store, ch);
		}

	}

	public static int menu() {

		System.out.println("--- Menu ---");
		System.out.println("1. Create new account");
		System.out.println("2. Add video cassete to store");
		System.out.println("3. Give video cassette");
		System.out.println("4. Return video cassette");
		System.out.println("5. Show accounts");
		System.out.println("6. Show not returned cassettes");
		System.out.println("0. Exit");
		System.out.print("Enter number for option: ");

		return sc.nextInt();
	}

	public static void optionsExecute(Store store, int choice) {
		switch (choice) {
		case 1:
			addAccount(store);
			break;
		case 2:
			addVideoCassette(store);
			break;
		case 3:
			getVideoCassette(store);
			break;
		case 4:
			returnVideoCassette(store);
			break;
		case 5:
			store.showAccounts();
			break;
		case 6:
			store.showNotReturned();
			break;
		default:
			System.out.println("Option " + choice + " not exist! Please, try again.");
		}

	}

	public static void addAccount(Store store) {
		System.out.println("Create a new account");
		System.out.print("Enter a name: ");
		String name;
		byte minNameSimbols = 2;
		byte maxNameSimbols = 50;
		boolean isFirstRead = true;

		while (true) {
			if (isFirstRead) {
				sc.nextLine();
				isFirstRead = false;
			} else {
				name = sc.nextLine();

				if ((name.length() < minNameSimbols || name.length() > maxNameSimbols)) {
					System.out.printf("Input a name beetwin %d and %d simbols: ", minNameSimbols, maxNameSimbols);

				} else {
					break;
				}
			}
		}

		store.addAccount(name);
	}

	public static void addVideoCassette(Store store) {

		System.out.println("Add a new video cassette to store");
		System.out.print("Enter a film title: ");
		String title;
		byte minTitleSimbols = 2;
		byte maxTitleSimbols = 50;
		boolean isFirstRead = true;

		while (true) {
			if (isFirstRead) {
				sc.nextLine();
				isFirstRead = false;
			} else {
				title = sc.nextLine();

				if ((title.length() < minTitleSimbols || title.length() > maxTitleSimbols)) {
					System.out.printf("Input a title beetwin %d and %d simbols: ", minTitleSimbols, maxTitleSimbols);

				} else {
					break;
				}
			}
		}

		store.addVideoCassette(title);

	}

	public static void getVideoCassette(Store store) {
		int accountIndex;
		int videocassetteIndex;

		System.out.println("Getting a video cassette");
		int accId;

		while (true) {
			System.out.print("Input account ID: ");
			accId = sc.nextInt();

			accountIndex = store.searchAccount(accId);

			if (accountIndex != -1) {
				break;
			} else {
				System.out.println("Account with ID=" + accId + " not exists! Try with existing one.");
			}
		}

		int vcId;
		while (true) {
			System.out.print("Input video cassette ID: ");
			vcId = sc.nextInt();

			videocassetteIndex = store.searchVideoCassette(vcId);

			if (videocassetteIndex != -1) {
				break;
			} else {
				System.out.println("Video cassette with ID=" + vcId + " not exists! Try with existing one.");
			}
		}

		store.takeVideoCassette(accountIndex, videocassetteIndex);
	}

	public static void returnVideoCassette(Store store) {
		int accountIndex;
		int videocassetteIndex;

		System.out.println("Returning a video cassette");
		int accId;

		while (true) {
			System.out.print("Input account ID: ");
			accId = sc.nextInt();

			accountIndex = store.searchAccount(accId);

			if (accountIndex != -1) {
				break;
			} else {
				System.out.println("Account with ID=" + accId + " not exists! Try with existing one.");
			}
		}

		int vcId;
		while (true) {
			System.out.print("Input video cassette ID: ");
			vcId = sc.nextInt();

			videocassetteIndex = store.searchVideoCassette(vcId);

			if (videocassetteIndex != -1) {
				break;
			} else {
				System.out.println("Video cassette with ID=" + vcId + " not exists! Try with existing one.");
			}
		}

		store.returnVideoCassette(accountIndex, videocassetteIndex);
	}
}
