package com.github.mdssjc.handson.jbehave;

import java.util.ArrayList;
import java.util.List;

public class ChangeMachine {

  public final int[] coinTypes = { 50, 25, 10, 5, 1 };

  public List<Integer> getCoinsForChangeOf(double value) {
    if (value >= 1.00 || value <= 0.00) {
      throw new RuntimeException();
    }

    List<Integer> list = new ArrayList<>();
    
    int amountOfCents = (int) (value * 100);
    for (int coinType : coinTypes) {
      while (amountOfCents >= coinType) {
        amountOfCents -= coinType;
        list.add(coinType);
      }
    }

    return list;
  }
}
