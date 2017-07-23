package com.github.mdssjc.orionsorbits;

public class OrionsOrbits {

  public static void main(final String[] args) throws Exception {
    final OrionsOrbits oo = new OrionsOrbits();
    System.out.println("Adding order...");
    oo.orderMeal(new String[]{"Fish and Chips"}, "VS01");
  }

  public void orderMeal(final String[] options, final String flightNo) throws Exception {
    final MercuryMeals mercuryMeals = MercuryMeals.getInstance();
    final Order order = mercuryMeals.createOrder();

    for (int x = 0; x < options.length; x++) {
      final MealOption mealOption = mercuryMeals.getMealOption(options[x]);

      if (mealOption != null) {
        order.addMealOption(mealOption);
      } else {
        throw new MealOptionNotFoundException(mealOption);
      }
    }

    order.addKeyword(flightNo);

    if (!mercuryMeals.submitOrder(order)) {
      throw new OrderNotAcceptedException(order);
    }
  }
}
