package decoratorPattern;

public class Account {
	private int account_id;
	private String client_name;
	public Account(){}

	public Account(int id, String client) {
		this.account_id = id;
		this.client_name = client;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
}
