package com.github.mdssjc.orionsorbits;

import java.util.ArrayList;
import java.util.List;

public class Order {

  private String keyword;
  private final List<MealOption> mealOptions = new ArrayList<>();

  public void addKeyword(final String keyword) {
    this.keyword = keyword;
  }

  public void addMealOption(final MealOption mealOption) {
    this.mealOptions.add(mealOption);
  }
}
