package dk.cphbusiness.banking;

public class DummyBank implements Bank {

  @Override
  public Account findAccount(String number) {
    throw new UnsupportedOperationException("Not supported yet.");
    }
  
  }
