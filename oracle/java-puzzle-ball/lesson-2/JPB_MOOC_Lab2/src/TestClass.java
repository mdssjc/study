/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

public class TestClass {

  public static void main(String[] args) {

    //Create new instances
    SavingsAccount savings1 = new SavingsAccount("Duke", 100);

    //Call methods on instances
    savings1.printDetails();

    savings1.deposit(5000);
    savings1.withdraw(100);
    savings1.earnInterest();
    savings1.earnInterest();

    //Create new instances
    CheckingAccount checking1 = new CheckingAccount("Duke", 0);
    CheckingAccount checking2 = new CheckingAccount("Carrie", 500000);
    CheckingAccount checking3 = new CheckingAccount("Duke", 1000);

    //Call methods on instances
    checking1.printDetails();
    checking2.printDetails();
    checking3.printDetails();
    checking1.printDetails();
  }
}
