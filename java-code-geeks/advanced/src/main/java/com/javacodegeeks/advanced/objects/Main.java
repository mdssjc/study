package com.javacodegeeks.advanced.objects;

public class Main {

  public static void main(String[] args) {
    final Person person = new Person("John", "Smith", "john.smith@domain.com");
    System.out.println(person);

    final Office office = new Office(person, person);
    System.out.println(office);
  }
}
