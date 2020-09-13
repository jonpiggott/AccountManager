
import java.util.*;

public class Account {

	private String userName;
	private String password;
	public static ArrayList<Account> accountList = new ArrayList<Account>();

	public Account(String uName, String pWord) {
		this.userName = uName;
		this.password = pWord;
		accountList.add(this);
	}

	public String getName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public static void printAccounts() {
		for (Account accnt : accountList) {
			System.out.println("|||||Displaying User Account Information|||||");
			System.out.println(accnt.getName());
			System.out.println(accnt.getPassword());
		}
	}

	public void loginAccount() {

	}

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		int menuOption;

		do {
			System.out.println("Enter: 0 = exit, 1 = new account, 2 = login");
			menuOption = userInput.nextInt();
			String bufferLine = userInput.nextLine();

			if (menuOption == 0) {

				System.out.println("Exiting...");
				System.exit(0);

			} else if (menuOption == 1) {

				System.out.println("New account creation starting...");

				System.out.println("Enter your username: ");
				String userNameInput = userInput.nextLine();
				System.out.println("Enter your password: ");
				String userPasswordInput = userInput.nextLine();

				Account testAccount = new Account(userNameInput,userPasswordInput);
				printAccounts();

			} else {

				System.out.println("Login for system...");

			}
		} while (menuOption != 0);

		


	}

}