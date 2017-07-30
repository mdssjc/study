package com.github.mdssjc.orionsorbits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MercuryMealsTest {

  private String[] options;
  private String flightNo;

  @Before
  public void setUp() {
    this.options = new String[]{"Fish and chips"};
    this.flightNo = "VS01";
  }

  @After
  public void tearDown() {
    this.options = null;
    this.flightNo = null;
  }

  @Test
  public void testOrderRegularMeal()
      throws MealOptionNotFoundException, OrderNotAcceptedException,
      MercuryMealsConnectionException {
    final MercuryMeals mercuryMeals = MercuryMeals.getInstance();
    final Order order = mercuryMeals.createOrder();
    final MealOption mealOption = mercuryMeals.getMealOption(this.options[0]);
    if (mealOption != null) {
      order.addMealOption(mealOption);
    } else {
      throw new MealOptionNotFoundException(mealOption);
    }
    order.addKeyword(this.flightNo);
    if (!mercuryMeals.submitOrder(order)) {
      throw new OrderNotAcceptedException(order);
    }
  }
}
