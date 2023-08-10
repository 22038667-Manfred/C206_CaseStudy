
import java.util.ArrayList;

public class MoneyExchange {

	public static ArrayList<Currency> currList =  new ArrayList<Currency>();
	public static ArrayList<Account> accList = new ArrayList<Account>();
	public static ArrayList<Transaction> transactList = new ArrayList<Transaction>();
	public static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	public static boolean isAdmin = false;

	public static void main(String[] args) {
		// Test data
		currList.add(new Currency("China", "CNY","Yuan",5.38));
		currList.add(new Currency("Columbia","COP","Peso", 2936.58));
		currList.add(new Currency("India","INR","Rupee",61.93));
		currList.add(new Currency("Malaysia","MYR","Ringgit",3.55));

		Users scrumMaster = new Users("Rishika","Scrum Master",true,"001");
		accList.add(new Account(scrumMaster,"rishika05","12345",92287068));

		Users softwareEng = new Users("Asmond","Software Engineer",true,"002");
		accList.add(new Account(softwareEng,"asmond0811","12345",9338707));
		
		Users account1 = new Users("Queenie","Customer 1",false,"003");
		accList.add(new Account(account1,"queenie101","12345",91297938));
		
		
		System.out.println("Welcome to RemitNow !!!");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		int opt = Helper.readInt("Enter option: ");
		while(opt!=3) {

			if(opt == 1) {
				Account acc = validateAcc();
				if(acc!=null) {
					validateAdmin(acc);
					loggedInMenuMain();
				} else {
					System.out.println("Invalid username or password entered!!!");
				}
			} else if(opt == 2) {
				// Rishika and Dairus pair program
			}
			System.out.println("Welcome to RemitNow !!!");
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			opt = Helper.readInt("Enter option: ");

		}


		System.out.println("Thank you for using MeRemit!!!");

	}
	

	public static void signUp() {

	}
	public static void Menu() {
		System.out.println("Menu");
		System.out.println("1. Users");
		System.out.println("2. Accounts");
		System.out.println("3. Transactions");
		System.out.println("4. Currencies");
		System.out.println("5. Feedback");
		System.out.println("6. Log out");
	}

	public static void currMenu() {
		System.out.println("1. View all currencies");
		System.out.println("2. Add a new currency");
		System.out.println("3. Edit an existing currency");
		System.out.println("4. Delete an existing currency");
		System.out.println("5. Search for a currency");
		System.out.println("6. View Main Menu");
	}


	public static void loggedInMenuMain() {
		Menu();
		int opt = Helper.readInt("Please choose an option: ");
		while(opt !=6) {
			if (opt == 1) {
				// Add users selection menu
			} else if (opt == 2) {
				// Add accounts selection menu
			} else if (opt == 3) {
				System.out.println("1. Make a transaction");
			} else if (opt == 4) {

				currMenu();
				int subOpt = Helper.readInt("Please choose an option: ");
				while(subOpt != 6) {
					switch (subOpt) {
					case 1:
						viewAllCurr();
						break;
					case 2:
						addCurr();
						break;
					case 3:
						editRate();
						
						break;
					case 4:
						deleteCurr();
						break;
					case 5:
						searchCurr();
						break;
					default:
						System.out.println("Invalid choice entered");
					}
					currMenu();
					subOpt = Helper.readInt("Please choose an option: ");
				}

			} else if (opt == 5) {
				// Add feedback selections menu
			}
			Menu();
			opt = Helper.readInt("Please choose an option: ");
		}
		System.out.println("Logged out");
		System.out.println(" ");
		isAdmin = false;
	}

	public static Account validateAcc() {
		Account validAcc = null;
		String usr = Helper.readString("Enter username: ");
		String pwd = Helper.readString("Enter password: ");

		for (Account acc : accList) {
			if(acc.getUsername().equalsIgnoreCase(usr) && acc.getPassword().equals(pwd)) {
				validAcc = acc;
			}
		}
		return validAcc;
	}

	public static void validateAdmin(Account acc) {
		if (acc.getUsers().getAdmin() == true) {
			isAdmin = true;
		}
	}

	public static void makeTransaction() {
		Account acc = null;
		String accSent = Helper.readString("Enter account ID to transfer: ");
		double amt = Helper.readDouble("Enter amount to transfer ($SGD): ");
		String curr = Helper.readString("Enter currency to transfer: ");


	}


	public static void addCurr() {
		System.out.println(isAdmin);
		String country = Helper.readString("Enter country name: ");
		String code = Helper.readString("Enter country code: ");
		String currName = Helper.readString("Enter currency name: ");
		double rate = Helper.readDouble("Enter exhange rate: ");

		currList.add(new Currency(country,code,currName,rate));
		System.out.println("Currency successfully added");

	}

	public static void editRate() {
		if (isAdmin == true) {
			boolean found = true;
			String code = Helper.readString("Enter country code to edit exchange rate: ");
			for(Currency curr : currList) {
				if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
					double rate = Helper.readDouble("Enter new rate: ");
					curr.setExchangeRate(rate);
					System.out.println(curr.getCurrencyCode() + "rate changed successfully!");
					found = true;
					break;
				} else {
					found = false;
				}
			}
			if (!found) {
				System.out.println("Unknown currency code");
			}
		} else {
			System.out.println("Administrative rights required for this!!!");
		}
	}

	public static void deleteCurr() {
		boolean found = true;
		String code = Helper.readString("Enter country code to delete: ");
		for(Currency curr : currList) {
			if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
				char opt = Helper.readChar("Do you wish to delete " + curr.getCurrencyCode() + " > (Y/N) ");
				if (Character.toLowerCase(opt) == 'y') {
					currList.remove(curr);
					System.out.println(curr + " successfully deleted.");
					found = true;
					break;
				}
			} else {
				found = false;
			}
		}
		if (!found) {
			System.out.println("Unknown currency code");
		}
	}

	public static void viewAllCurr() {
		String output = String.format("%-10s %-10s %-10s %-10s\n","COUNTRY","CODE","CURRENCY","RATE");

		for(Currency curr : currList) {
			output += String.format("%-10s %-10s %-10s %-10.2f\n", curr.getCountry(),curr.getCurrencyCode(),curr.getCurrencyName(),curr.getExchangeRate());
		}

		System.out.println(output);

	}

	public static void searchCurr() {

	}

	public Account verifyAccount(String usr, String pwd) {

		return accList.get(0);

	}


}
