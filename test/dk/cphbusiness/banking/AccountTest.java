package dk.cphbusiness.banking;

import static org.hamcrest.CoreMatchers.is;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
  public final Mockery context = new JUnitRuleMockery();
  
  @Test
  public void createInternalAccountTest() throws Exception {
    // Bank bank = new Bank() {};
    Bank bank = new DummyBank();
    String number = "#4711";
    Account account = new Account(bank, number);
    assertThat(account.getNumber(), is(number));
    assertThat(account.getBalance(), is(0));
    assertTrue(account.isInternal());
    assertThat(account.getBank(), is(bank));
    }
  
  @Test
  public void createCustomerAccountTest() throws Exception {
    Bank bank = context.mock(Bank.class);
    Customer customer = context.mock(Customer.class);
    String number = "#4712";
    Account account = new Account(bank, customer, number);
    assertThat(account.getNumber(), is(number));
    assertThat(account.getBalance(), is(0));
    assertFalse("should return false", account.isInternal());
    assertThat(account.getBank(), is(bank));
    assertThat(account.getCustomer(), is(customer));
    }
  
  @Test
  public void transferAmountTest() throws Exception {
    final Bank bank = context.mock(Bank.class);
    String sourceNumber = "#4713";
    final String targetNumber = "#4714";
    Account sourceAccount = new Account(bank, sourceNumber);
    final Account targetAccount = new Account(bank, targetNumber);
    int sourceBalance = sourceAccount.getBalance();
    int targetBalance = targetAccount.getBalance();
    int amount = 200;
    
    context.checking(new Expectations() {{
      oneOf(bank).findAccount(targetNumber);
      will(returnValue(targetAccount));
      }});
    
    sourceAccount.transfer(targetNumber, amount);
    assertThat(sourceAccount.getBalance(), is(sourceBalance - amount));
    assertThat(targetAccount.getBalance(), is(targetBalance + amount));
    }
  
  }
