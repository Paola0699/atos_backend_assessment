package decoratorPattern;

public class SavingAccount implements BankAccount{
	@Override
	public void OpenAccount(Account ac) {
		System.out.println("A Saving Account was opened");
		System.out.println("Account Client: " + ac.getClient_name());
	}
}
