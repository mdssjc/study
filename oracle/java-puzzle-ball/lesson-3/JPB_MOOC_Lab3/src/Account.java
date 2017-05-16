/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

public class Account {

  protected static int nextAccountNum = 0;
  //Fields
  protected String accountOwner;
  protected double balance;
  protected int accountNum;

  //Constructor
  public Account(String o, double b) {
    accountOwner = o;
    balance = b;
    setAccountNumber();
    System.out.println("New Account:");
    printDetails();
  }

  //Methods
  public void printDetails() {
    System.out.println("Account Owner: " + accountOwner);
    System.out.println("Balance: $" + balance);
    System.out.println("");
  }

  public void deposit(double x) {
    if (x > 0) {
      balance = balance + x;
      System.out.println("Deposit: $" + x);
    } else {
      System.out.println("Cannot deposit negative amount: " + x);
    }
    printDetails();
  }

  public void withdraw(double x) {
    if (x > 0 && (balance - x > 0)) {
      balance = balance - x;
      System.out.println("Withdraw: $" + x);
    } else if (x < 0) {
      System.out.println("Cannot withdraw negative amount: " + x);
    } else if (balance - x < 0) {
      System.out.println(
          "Cannot withdraw $" + x + " from $" + balance + " account");
      System.out.println("Balance cannot go negative.");
    }
    printDetails();
  }

  private void setAccountNumber() {
    accountNum = nextAccountNum;
    nextAccountNum++;
  }
}
