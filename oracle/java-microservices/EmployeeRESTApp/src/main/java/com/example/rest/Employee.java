/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example.rest;

public class Employee {

  private final long id;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;
  private final String birthDate;
  private final String title;
  private final String dept;

  public Employee() {
    this.id = 0;
    this.firstName = "";
    this.lastName = "";
    this.email = "";
    this.phone = "";
    this.birthDate = "";
    this.title = "";
    this.dept = "";
  }

  public Employee(final long id, final String firstName, final String lastName, final String email, final String phone, final String birthDate, final String title, final String dept) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.birthDate = birthDate;
    this.title = title;
    this.dept = dept;
  }

  public long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getBirthDate() {
    return this.birthDate;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDept() {
    return this.dept;
  }

  @Override
  public String toString() {
    return "ID: " + this.id
           + " First Name: " + this.firstName
           + " Last Name: " + this.lastName
           + " EMail: " + this.email
           + " Phone: " + this.phone
           + " Birth Date: " + this.birthDate
           + " Title: " + this.title
           + " Department: " + this.dept;
  }
}
