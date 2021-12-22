package decoratorPattern;

public class ShieldAccountDecorator extends AccountDecorator{
	public ShieldAccountDecorator(BankAccount decoratedAccount) {
		super(decoratedAccount);
	}
	@Override
	public void OpenAccount(Account ac) {
		decoratedAccount.OpenAccount(ac);
		addShield(ac);
	}
	public void addShield(Account ac) {
		System.out.println("Shield added to account of:" + ac.getClient_name());
	}
}
