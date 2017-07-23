package com.github.mdssjc.orionsorbits;

public class MealOptionNotFoundException extends Exception {

  private final MealOption mealOption;

  public MealOptionNotFoundException(final MealOption mealOption) {
    this.mealOption = mealOption;
  }
}
