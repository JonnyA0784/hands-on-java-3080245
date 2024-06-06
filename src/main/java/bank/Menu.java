package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Menu {
  private Scanner scanner;

  private Customer authenticateUser(){
    System.out.println("Please enter your username:");
    String username = scanner.next();
    System.out.println("Now, enter your password:");
    String password = scanner.next();
    Customer user = null;
    try{
      user = Authenticator.login(username, password);
      //System.out.println("Login Successful");
    } catch(LoginException e){
      System.out.println("There was an error: " + e.getMessage());
    }
    return user;
  }


  public void handleOptions(Customer user, Account userAccount){
    int choice = 0; 
    Scanner input = new Scanner(System.in);
    System.out.println("Login Successful, please select from the following options:");
    while(choice!=4 && user.isAuthenticated()){
    System.out.println("1. Deposit Money");  
    System.out.println("2. Withdraw");   
    System.out.println("3. Check Balance");
    System.out.println("4. Exit");
    choice = input.nextInt();
    switch(choice){
      case 1:
      System.out.println("How much money would you like to deposit?");
      double deposit = input.nextDouble();
      System.out.println("Balance before deposit");
      userAccount.setBalance((userAccount.getBalance()+deposit));
      System.out.println("After depositing you now have: " + userAccount.getBalance());
      break;

      case 2:
        System.out.println("How much would you like to withdraw?");
        double withdraw = input.nextDouble();
        System.out.println("Balance before withdrawal: " + userAccount.getBalance());
        userAccount.setBalance((userAccount.getBalance()-withdraw));
        System.out.println("Balance is now: " + userAccount.getBalance());
        break;

      case 3:
        System.out.println("Checking balance....");
        System.out.println("Balance is " + userAccount.getBalance());
        break;

      case 4:
        System.out.println("Thank you for using our online banking system, now exiting");
        user.setAuthenticated(false);
        break;

      default:
          System.out.println("Option not recognized, please make sure you picked a valid option");
        break;
      }
    }
    input.close();
  }

  public static void main(String[] args) {

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    System.out.println("This will be a menu for your banking options, please login");
    Customer user = menu.authenticateUser();
    Account userAccount = DataSource.getAccount(user.getAccountId());

    menu.handleOptions(user,userAccount);
    
    menu.scanner.close();


  }


}
