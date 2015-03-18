package dk.cphbusiness.banking;

public class Account {
  private Bank bank;
  private String number;
  
  public Account(Bank bank, String number) {
    this.bank = bank;
    this.number = number;
    }
  
  public boolean isInternal() {
    return true;
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
  
  }
