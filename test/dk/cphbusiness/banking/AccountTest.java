package dk.cphbusiness.banking;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
  
  @Test
  public void createInternalAccountTest() throws Exception {
    Bank bank = new Bank() {};
    String number = "#4711";
    Account account = new Account(bank, number);
    assertThat(account.getNumber(), is(number));
    assertThat(account.getBalance(), is(0));
    assertTrue(account.isInternal());
    assertThat(account.getBank(), is(bank));
    }
  
  }
