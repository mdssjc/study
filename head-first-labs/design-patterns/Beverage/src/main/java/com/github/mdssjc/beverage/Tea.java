package com.github.mdssjc.beverage;

public class Tea extends CaffeineBeverage {

  @Override
  public void brew() {
    System.out.println("Steeping the tea");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding Lemon");
  }

  @Override
  public boolean customerWantsCondiments() {
    final String answer = UserInput.getUserInput(
        "Would you like lemon with your tea");

    return answer.toLowerCase()
                 .startsWith("y");
  }
}
