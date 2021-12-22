package decoratorPattern;

public class App {
	public static void main(String[] args) {
		Account ac = new Account(1,"Paola Perez");
		
		BankAccount account = new SavingAccount();
		BankAccount shieldAccount = new ShieldAccountDecorator(account);
		
		//account.OpenAccount(ac);
		shieldAccount.OpenAccount(ac);
	}
}
