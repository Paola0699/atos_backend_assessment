package decoratorPattern;

public abstract class AccountDecorator implements BankAccount {
	protected BankAccount decoratedAccount;
	
	public AccountDecorator(BankAccount decoratedAccount) {
		this.decoratedAccount = decoratedAccount;
	}
	
	@Override
	public void OpenAccount(Account ac) {
		this.decoratedAccount.OpenAccount(ac);
	}
}
