package com.github.mdssjc.orionsorbits;

//Follows the Singleton design pattern
public class MercuryMeals {

  private static MercuryMeals instance;
  public MercuryMeals meallythang;
  private Order cO;
  private final String qk = "select * from order-table where keywords like %1;";

  public MercuryMeals() {
  }

  public static MercuryMeals getInstance() {
    instance = new MercuryMeals();
    return instance;
  }

  // TODO Really should document this at some point... TBD 
  public Order createOrder() {
    return new Order();
  }

  public MealOption getMealOption(final String option)
      throws MercuryMealsConnectionException {
    if (MM.establish()
          .isAnyOptionsForKey(option)) {
      return MM.establish()
               .getMealOption(option)[0];
    }
    return null;
  }

  public boolean submitOrder(final Order cO) {
    try {
      final MM mm = MM.establish();
      mm.su(this.cO);
    } catch (final Exception e) { // write out an error message
    }
    return false;
  }

  public Order[] getOrdersThatMatchKeyword(final String qk)
      throws MercuryMealsConnectionException {
    final Order[] o;
    try {
      o = MM.establish()
            .find(qk, qk);
    } catch (final Exception e) {
      return null;
    }
    return o;
  }
}
