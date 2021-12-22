package decoratorPattern;

public class CurrentAccount implements BankAccount {
	@Override
	public void OpenAccount(Account ac) {
		System.out.println("A Current Account was opened");
		System.out.println("Account Client: " + ac.getClient_name());
	}
}
