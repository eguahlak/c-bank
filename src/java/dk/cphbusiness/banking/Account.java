package dk.cphbusiness.banking;

public class Account {
  private Bank bank;
  private Customer customer;
  private String number;
  private int balance = 0;
  
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
    this.balance -= amount;
    targetAccount.balance += amount;
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
    return balance;
    }
  
  public Customer getCustomer() {
    return customer;
    }
  
  }
