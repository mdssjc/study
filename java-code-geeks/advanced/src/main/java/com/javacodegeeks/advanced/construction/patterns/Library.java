package com.javacodegeeks.advanced.construction.patterns;

public class Library implements BookFactory {

  @Override
  public Book newBook() {
    // return new PaperBook();
    return Book.newBook("Paper Book");
  }
}
