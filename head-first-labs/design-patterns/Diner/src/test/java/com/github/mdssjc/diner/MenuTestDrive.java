package com.github.mdssjc.diner;

public class MenuTestDrive {

  public static void main(final String[] args) {
    final PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    final DinerMenu dinerMenu = new DinerMenu();

    final Waitress waitress = new TheWaitress(pancakeHouseMenu, dinerMenu);

    waitress.printMenu();
  }
}
