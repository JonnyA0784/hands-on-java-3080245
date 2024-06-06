package bank;

public class Customer {
  private int id, accountId;
  private String name, username, password;
  private boolean authenticated;

  public boolean isAuthenticated() {
    return this.authenticated;
  }

  public boolean getAuthenticated() {
    return this.authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

  public Customer(int id, String name, String username, String password, int accountId){
    setAccountId(accountId);
    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAuthenticated(false);

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}
