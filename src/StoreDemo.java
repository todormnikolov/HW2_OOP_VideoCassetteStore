import java.util.Scanner;

public class StoreDemo {

	private static Scanner sc = new Scanner(System.in);;

	public static void main(String[] args) {

		Store store = new Store();
		
		int ch = menu();
		optionsExecute(store, ch);

		// VideoCassette vc1 = new VideoCassette("Real Steel");
		// VideoCassette vc2 = new VideoCassette("Scary movie 1");
		// VideoCassette vc3 = new VideoCassette("Scary movie 2");
		// VideoCassette vc4 = new VideoCassette("Scary movie 3");
		// VideoCassette vc5 = new VideoCassette("Scary movie 4");
		// VideoCassette vc6 = new VideoCassette("Scary movie 5");
		//
		// Account acc1 = new Account("Ivan Ivanov");
		// Account acc2 = new Account("Peter Petrov");
		// Account acc3 = new Account("Ivan Kostov");
		// Account acc4 = new Account("Ivan Petkov");
		//
		// vc1.getVideoCassette(acc1);
		// vc1.printInfo();
		// vc2.getVideoCassette(acc4);
		// vc2.printInfo();
		// vc3.printInfo();
		//
		// vc2.returnVideoCassette(acc4);
		//
		// vc1.printInfo();
		// vc2.printInfo();
		// vc3.printInfo();

	}

	public static int menu() {
		int choice;
		do {
			System.out.println("1. Add account");
			System.out.println("2. Add video cassete");
			System.out.println("3. Give video cassette");
			System.out.println("4. Return video cassette");
			System.out.println("5. Show accounts");
			System.out.println("6. Show not returned cassettes");
			System.out.println("0. Exit");
			System.out.print("Enter number for option: ");
			choice = sc.nextInt();

		} while (choice < 0 || choice > 6);

		return choice;
	}

	public static void optionsExecute(Store store, int choice) {
		switch (choice) {
		case 1:
			addAccount(store);
			break;
		case 2:
			//store.addVideoCassette();
			break;
		case 3:
			//store.getVideoCassette();
		case 4:
			//store.returnVideoCassette();
		case 5:
			store.showAccounts();
			break;
		case 6:
			//store.showNotReturned();
		default:
			return;
		}
		menu();
	}

	public static void addAccount(Store store) {
		System.out.println("Create a new account");
		String name;
		do {
			System.out.print("Enter a name: ");
			name = sc.nextLine();
		} while (name.length() < 2 || name.length() > 50);
System.out.println(name);
		//Account acc = new Account(name);
		
		store.addAccount(name);
	}
	
//	public static void showAccount(Store store){
//		
//	}

}
