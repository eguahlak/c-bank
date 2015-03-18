package dk.cphbusiness.banking;

import static org.hamcrest.CoreMatchers.is;
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
  
  }
