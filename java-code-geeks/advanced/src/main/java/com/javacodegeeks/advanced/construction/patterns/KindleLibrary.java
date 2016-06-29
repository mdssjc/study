package com.javacodegeeks.advanced.construction.patterns;

public class KindleLibrary implements BookFactory {

  @Override
  public Book newBook() {
    // return new KindleBook();
    return Book.newBook("Kindle Book");
  }
}
