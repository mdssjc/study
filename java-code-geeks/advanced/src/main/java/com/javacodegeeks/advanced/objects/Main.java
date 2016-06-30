package com.javacodegeeks.advanced.objects;

public class Main {

  public static void main(String[] args) {
    final Person person = new Person("John", "Smith", "john.smith@domain.com");
    System.out.println(person);

    final Office office = new Office(person, person);
    System.out.println(office);

    final String str1 = new String("bbb");
    System.out.println("Using == operator: " + (str1 == "bbb"));
    System.out.println("Using equals() method: " + str1.equals("bbb"));
  }
}
