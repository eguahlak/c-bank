package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private Bank bank;
  private Customer customer;
  private String number;
//  private int balance = 0;
  private List<Movement> movements = new ArrayList<>();
  
  public Account(Bank bank, String number) {
    this.bank = bank;
    this.number = number;
    }
  
  public Account(Bank bank, Customer customer, String number) {
    this(bank, number);
    this.customer = customer;
    }

  public void transfer(String targetNumber, int amount) {
    Account targetAccount = bank.findAccount(targetNumber);
//    this.balance -= amount;
//    targetAccount.balance += amount;
    Movement movement = new Movement(this, targetAccount, amount);
    this.movements.add(movement);
    targetAccount.movements.add(movement);
    }
  
  public boolean isInternal() {
    return customer == null;
    }
  
  public String getNumber() {
    return number;
    }
  
  public Bank getBank() {
    return bank;
    } 
  
  public int getBalance() {
//    return balance;
    int balance = 0;
    for (Movement movement : movements) {
      if (movement.source == this) balance -= movement.amount;
      else balance += movement.amount;
      }
    return balance;
    }
  
  public Customer getCustomer() {
    return customer;
    }
  
  private static class Movement {
    private final Account source;
    private final Account target;
    private final int amount;
    
    Movement(Account source, Account target, int amount) {
      this.source = source;
      this.target = target;
      this.amount = amount;
      }

    }
  
  }
