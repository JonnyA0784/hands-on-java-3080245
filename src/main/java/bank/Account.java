package bank;

public class Account {
  private int id;
  private double balance;
  private String accountType;

  public Account(int id, String accountType, double balance) {
    setId(id);
    setBalance(balance);
    setAccountType(accountType);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  

}
