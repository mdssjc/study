/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ButtonController {

  ArrayList<Account> accountList = new ArrayList<>();
  TextField ownerSearchBar;
  TextField numberSearchBar;
  Button btn1;
  Button btn2;
  Button btn3;
  Button btn4;
  Button btn5;
  Button btn6;
  Button btn7;
  Button btn8;
  Predicate<Account> matchAccountOwner =
      a -> a.getAccountOwner()
            .equals(ownerSearchBar.getText());
  Predicate<Account> matchAccountNumber =
      a -> String.valueOf(a.getAccountNumber())
                 .equals(numberSearchBar.getText());

  public ButtonController(ArrayList list, TextField o, TextField n, Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8) {
    accountList = list;
    ownerSearchBar = o;
    numberSearchBar = n;
    btn1 = b1;
    btn2 = b2;
    btn3 = b3;
    btn4 = b4;
    btn5 = b5;
    btn6 = b6;
    btn7 = b7;
    btn8 = b8;
    interactions();
  }

  private void interactions() {
    btn1.setOnMousePressed(e -> button1Pressed());
    btn2.setOnMousePressed(e -> button2Pressed());
    btn3.setOnMousePressed(e -> button3Pressed());
    btn3.setOnMousePressed(e -> button3Pressed());
    btn4.setOnMousePressed(e -> button4Pressed());
    btn5.setOnMousePressed(e -> button5Pressed());
    btn6.setOnMousePressed(e -> button6Pressed());
    btn7.setOnMousePressed(e -> button7Pressed());
    btn8.setOnMousePressed(e -> button8Pressed());
  }

  private void button1Pressed() {
    accountList.stream()
               .filter(matchAccountOwner)
               .forEach(Account::printDetails);
  }

  private void button2Pressed() {
    accountList.stream()
               .filter(matchAccountOwner)
               .forEach(a -> {
                 System.out.println("CLOSING");
                 a.printDetails();
               });
    accountList.removeIf(matchAccountOwner);
  }

  private void button3Pressed() {
    accountList.stream()
               .filter(matchAccountNumber)
               .forEach(a -> a.deposit(200));
  }

  private void button4Pressed() {
    accountList.stream()
               .filter(matchAccountNumber)
               .forEach(a -> a.withdraw(200));
  }

  private void button5Pressed() {
    accountList.stream()
               .filter(a -> a.balance >= 20000)
               .forEach(a -> {
                 System.out.printf("Bonus for high %s balance.%n",
                                   a.getAccountType());
                 a.deposit(20);
               });
  }

  private void button6Pressed() {
    accountList.stream()
               .filter(a -> a.getAccountType()
                             .equals("Savings Account"))
               .forEach(a -> ((SavingsAccount) a).earnInterest());
  }

  private void button7Pressed() {
    accountList.stream()
               .filter(a -> a.getTransactions() <= 1)
               .forEach(a -> {
                 System.out.println("Charge Fee");
                 a.withdraw(35);
               });
  }

  private void button8Pressed() {
    accountList.stream()
               .forEach(Account::resetTransactions);
  }
}
