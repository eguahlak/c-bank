package dk.cphbusiness.banking;

public class Account {
  private Bank bank;
  private Customer customer;
  private String number;
  
  public Account(Bank bank, String number) {
    this.bank = bank;
    this.number = number;
    }
  
  public Account(Bank bank, Customer customer, String number) {
    this(bank, number);
    this.customer = customer;
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
    return 0;
    }
  
  public Customer getCustomer() {
    return customer;
    }
  
  }
