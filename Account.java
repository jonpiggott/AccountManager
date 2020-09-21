import java.io.*;
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
		System.out.println("|||||Displaying User Account Information|||||");
		for (Account accnt : accountList) {
			System.out.println(accnt.getName());
			System.out.println(accnt.getPassword());
		}
	}

	public static void loginAccount(String username, String password) {
		System.out.println("Login with username: " + username);
		System.out.println("Login with password: " + password);
		boolean foundAccount = false;
		for (Account accnt : accountList) {
			if (username.equals(accnt.getName()) && password.equals(accnt.getPassword())) {
				System.out.println("||||Login SUCCESSFUL||||");
				foundAccount = true;
			}
		}
		if (!foundAccount) {
				System.out.println("||||Login FAILED||||");
		}
	}

	public static void loadAccounts() {
		try {
			ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream("Accounts.txt"));
			while (true) {	
				try {
					Account loadAccount = (Account)fileInput.readObject();
					accountList.add(loadAccount);
				} catch (EOFException e) {
					System.out.println("File has been loaded succesfully");
					break;
				}	
			}		
			fileInput.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error in file writing");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error in file writing");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error in file writing");
			e.printStackTrace();
		}
	}

	public static void saveAccounts() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Accounts.txt"));
			for (Account accnt : accountList) {
				if (accnt != null) {
					outputStream.writeObject(accnt);
				}
			}
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error in file writing");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		loadAccounts();

		Scanner userInput = new Scanner(System.in);
		int menuOption;

		do {
			System.out.println("Enter: 0 = exit, 1 = new account, 2 = login");
			menuOption = userInput.nextInt();
			String bufferLine = userInput.nextLine();

			String userNameInput;
			String userPasswordInput;

			switch (menuOption) {
				case 0:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				case 1:
					System.out.println("New account creation starting...");

					System.out.println("Enter your username: ");
					userNameInput = userInput.nextLine();
					System.out.println("Enter your password: ");
					userPasswordInput = userInput.nextLine();

					Account testAccount = new Account(userNameInput,userPasswordInput);
					printAccounts();
					break;
				case 2:
					System.out.println("Login for system...");
					System.out.println("Enter your username: ");
					userNameInput = userInput.nextLine();
					System.out.println("Enter your password: ");
					userPasswordInput = userInput.nextLine();

					loginAccount(userNameInput, userPasswordInput);
					break;
				default:
					System.out.println("Invalid Entry");
					break;
			}
		} while (true);
	}
}