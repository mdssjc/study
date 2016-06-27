package com.javacodegeeks.advanced.construction;

public class ConstructorWithArguments {

  public ConstructorWithArguments(String arg1, String arg2) {
  }

  public ConstructorWithArguments(String arg1) {
    this(arg1, null);
  }
}
