/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

public class TestClass {

  public static void main(String[] args) {

    //Create new instances
    SavingsAccount savings1 = new SavingsAccount("Duke", 100);
    SavingsAccount savings2 = new SavingsAccount("Damien", 200);
    SavingsAccount savings3 = new SavingsAccount("Jessica", 500);
    SavingsAccount savings4 = new SavingsAccount("Herbert", 500);

    //Call methods on instances
    savings1.deposit(5000);
    savings1.withdraw(100);
    savings1.earnInterest();
    savings1.earnInterest();

    //Create new instances
    CheckingAccount checking1 = new CheckingAccount("Duke", 0);
    CheckingAccount checking2 = new CheckingAccount("Duke", 500000);

    //Call methods on instances
    checking1.deposit(-5000);
    checking1.deposit(5000);
    checking1.withdraw(-10000);
    checking1.withdraw(10000);
    checking2.withdraw(10000);
  }
}
