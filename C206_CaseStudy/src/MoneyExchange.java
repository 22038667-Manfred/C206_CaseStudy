
import java.util.ArrayList;

public class MoneyExchange {

	public static ArrayList<Currency> currList =  new ArrayList<Currency>();
	public static ArrayList<Account> accList = new ArrayList<Account>();
	public static ArrayList<Transaction> transactList = new ArrayList<Transaction>();
	public static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	
	public static void main(String[] args) {
		currList.add(new Currency("China", "CNY","Yuan",5.38));
		currList.add(new Currency("Columbia","COP","Peso", 2936.58));
		currList.add(new Currency("India","INR","Rupee",61.93));
		currList.add(new Currency("Malaysia","MYR","Ringgit",3.55));

		Users scrumMaster = new Users("Rishika","Scrum Master",true,"001");
		accList.add(new Account(scrumMaster,"rishika05","12345",92287068));

		Users softwareEng = new Users("Asmond","Software Engineer",true,"002");
		accList.add(new Account(softwareEng,"asmond0811","12345",9338707));
		
		System.out.println("Welcome to RemitNow !!!");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		int opt = Helper.readInt("Enter option: ");
		
		
		
		
	}

	public static void signUp() {

	}



	public static void addCurr() {
		String country = Helper.readString("Enter country name: ");
		String code = Helper.readString("Enter country code: ");
		String currName = Helper.readString("Enter currency name: ");
		double rate = Helper.readDouble("Enter exhange rate: ");

		currList.add(new Currency(country,code,currName,rate));
		System.out.println("Currency successfully added");

	}

	public static void editRate() {
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
