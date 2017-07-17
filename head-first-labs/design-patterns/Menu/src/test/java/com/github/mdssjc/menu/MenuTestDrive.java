package com.github.mdssjc.menu;

public class MenuTestDrive {

  public static void main(final String[] args) {
    final Menu pancakeHouseMenu = new PancakeHouseMenu();
    final Menu dinerMenu = new DinerMenu();
    final Menu cafeMenu = new CafeMenu();

    final Waitress waitress = new TheWaitress(pancakeHouseMenu, dinerMenu,
                                              cafeMenu);

    waitress.printMenu();
  }
}
