/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

public class CheckingAccount {

  //Static
  private static int nextAccountNum = 0;
  private static String accountType="Checking Account";
  //Fields
  private String accountOwner;
  private double balance;
  private int accountNum;

  //Constructor
  public CheckingAccount(String o, double b) {
    accountOwner = o;
    balance = b;
    setAccountNumber();
  }

  //Methods
  public void printDetails() {
    System.out.println(accountType + " #" + accountNum);
    System.out.println("Account Owner: " + accountOwner);
    System.out.println("Balance: $" + balance);
    System.out.println("");
  }

  public void deposit(double x) {
    if (x > 0) {
      balance = balance + x;
      System.out.println("Deposit: $" + x);
      printDetails();
    } else {
      System.out.println("Cannot deposit negative amount: " + x);
      System.out.println("");
    }
  }

  public void withdraw(double x) {
    if (x > 0 && (balance - x > 0)) {
      balance = balance - x;
      System.out.println("Withdraw: $" + x);
      printDetails();
    } else if (x < 0) {
      System.out.println("Cannot withdraw negative amount: " + x);
      System.out.println("");
    } else if (balance - x < 0) {
      System.out.println(
          "Cannot withdraw $" + x + " from $" + balance + " account");
      System.out.println("Balance cannot go negative.");
      System.out.println("");
    }
  }

  private void setAccountNumber() {
    accountNum = nextAccountNum;
    nextAccountNum++;
  }
}
