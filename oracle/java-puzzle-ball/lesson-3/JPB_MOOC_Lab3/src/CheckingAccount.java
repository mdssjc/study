/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

public class CheckingAccount extends Account {

  //Fields
  private static String accountType = "Checking Account";

  //Constructor
  public CheckingAccount(String o, double b) {
    super(o, b);
  }

  //Methods
  public void printDetails() {
    System.out.println(accountType + " #" + accountNum);
    super.printDetails();
  }
}
