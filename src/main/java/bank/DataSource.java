package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect(){
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(db_file);
      //System.out.println("Connected Successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Customer getCustomer(String username){
    String sqlQuery = "select * from customers where username = ?";
    Customer user = null;
    try (Connection connect = connect(); 
    PreparedStatement statement = connect.prepareStatement(sqlQuery)) {
      statement.setString(1,username);

      try(ResultSet results = statement.executeQuery()){
        user = new Customer(
          results.getInt("id"), 
          results.getString("name"), 
          results.getString("username"), 
          results.getString("password"), 
          results.getInt("account_id"));
      }
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return user;
  }

  public static Account getAccount(int accountID){
    String sqlQuery = "select * from accounts where id = ?";
    Account userAccount = null;

    try(Connection connect = connect(); PreparedStatement statement = connect.prepareStatement(sqlQuery)){
      statement.setInt(1, accountID);
      try(ResultSet results = statement.executeQuery()){
        userAccount = new Account(
          results.getInt("id"), results.getString("type"), results.getDouble("balance"));
      }
    }
    catch(SQLException e){
      e.printStackTrace();
    }

    return userAccount;

  }
  public static void main(String[] args) {
    Customer customer = getCustomer("ohalbardv@booking.com");
    System.out.println(customer.getName());

    Account tesAccount = getAccount(customer.getAccountId());
    System.out.println(tesAccount.getBalance());
  }
}
