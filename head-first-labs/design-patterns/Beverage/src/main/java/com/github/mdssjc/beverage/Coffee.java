package com.github.mdssjc.beverage;

public class Coffee extends CaffeineBeverage {

  @Override
  public void brew() {
    System.out.println("Dripping Coffee through filter");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }

  @Override
  public boolean customerWantsCondiments() {
    final String answer = UserInput.getUserInput(
        "Would you like milk and sugar with your coffee");

    return answer.toLowerCase()
                 .startsWith("y");
  }
}
