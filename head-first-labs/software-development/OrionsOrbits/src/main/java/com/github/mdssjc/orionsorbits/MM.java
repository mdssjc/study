package com.github.mdssjc.orionsorbits;

public class MM {

  public static MM establish() {
    return new MM();
  }

  public boolean isAnyOptionsForKey(final String option) {
    return true;
  }

  public MealOption[] getMealOption(final String option) {
    return new MealOption[]{new MealOption(option)};
  }

  public void su(final Order order) throws Exception {
    throw new Exception("order not found");
  }

  public Order[] find(final String qk, final String extraOptions) {
    return new Order[]{new Order()};
  }
}
