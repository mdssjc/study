package com.javacodegeeks.advanced.objects;

import java.util.Objects;

public class Person implements Cloneable {

  private final String firstName;
  private final String lastName;
  private final String email;

  public Person(final String firstName, final String lastName,
      final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  // Step 0: Please add the @Override annotation, it will ensure that your
  // intention is to change the default implementation.
  @Override
  public boolean equals(Object obj) {
    // Step 1: Check if the 'obj' is null
    if (obj == null) {
      return false;
    }

    // Step 2: Check if the 'obj' is pointing to the this instance
    if (this == obj) {
      return true;
    }

    // Step 3: Check classes equality. Note of caution here: please do not use
    // the 'instanceof' operator unless class is declared as final. It may
    // cause an issues within class hierarchies.
    if (getClass() != obj.getClass()) {
      return false;
    }

    // Step 4: Check individual fields equality
    final Person other = (Person) obj;
    if (!Objects.equals(email, other.email)) {
      return false;
    } else if (!Objects.equals(firstName, other.firstName)) {
      return false;
    } else if (!Objects.equals(lastName, other.lastName)) {
      return false;
    }

    // if (email == null) {
    // if (other.email != null) {
    // return false;
    // }
    // } else if (!email.equals(other.email)) {
    // return false;
    // }
    //
    // if (firstName == null) {
    // if (other.firstName != null) {
    // return false;
    // }
    // } else if (!firstName.equals(other.firstName)) {
    // return false;
    // }
    //
    // if (lastName == null) {
    // if (other.lastName != null) {
    // return false;
    // }
    // } else if (!lastName.equals(other.lastName)) {
    // return false;
    // }

    return true;
  }

  // Please add the @Override annotation, it will ensure that your
  // intention is to change the default implementation.
  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, lastName);

    // final int prime = 31;
    //
    // int result = 1;
    // result = prime * result + ((email == null) ? 0 : email.hashCode());
    // result = prime * result + ((firstName == null) ? 0 :
    // firstName.hashCode());
    // result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());

    // return result;
  }

  // Please add the @Override annotation, it will ensure that your
  // intention is to change the default implementation.
  @Override
  public String toString() {
    return String.format("%s[email=%s, first name=%s, last name=%s]",
        getClass().getSimpleName(), email, firstName, lastName);
  }

  // Please add the @Override annotation, it will ensure that your
  // intention is to change the default implementation.
  @Override
  public Person clone() throws CloneNotSupportedException {
    return (Person) super.clone();
  }
}
