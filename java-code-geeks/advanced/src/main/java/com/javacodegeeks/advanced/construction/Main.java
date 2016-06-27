package com.javacodegeeks.advanced.construction;

public class Main {

  public static void main(String[] args) {
    NoConstructor noConstructorInstance = new NoConstructor();
    NoArgConstructor noArgConstructorInstance = new NoArgConstructor();
    ConstructorWithArguments constructorWithArguments = new ConstructorWithArguments("arg1", "arg2");
  }
}
