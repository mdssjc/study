package com.javacodegeeks.advanced.design;

interface A3 {

  default void performAction() {
  }
}

interface B3 extends A3 {

  @Override
  default void performAction() {
  }
}

interface C3 extends A3 {

  @Override
  default void performAction() {
  }
}

// E is not compilable unless it overrides performAction() as well
interface E3 extends B3, C3 {

  @Override
  default void performAction() {
    B3.super.performAction();
  }
}

public class DiamondOfDeath {
}
