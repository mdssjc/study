package com.github.mdssjc.handson.jbehave;

import java.util.ArrayList;
import java.util.List;

public class ChangeMachine {

  public List<Integer> getCoinsForChangeOf(double value) {
    List<Integer> list = new ArrayList<>();
    list.add((int) (value * 100));
    return list;
  }
}
