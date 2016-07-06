package com.javacodegeeks.advanced.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ImmutableClass {

  private final long               id;
  private final String[]           arrayOfStrings;
  private final Collection<String> collectionOfString;

  public ImmutableClass(final long id, final String[] arrayOfStrings,
      final Collection<String> collectionOfString) {
    this.id = id;
    this.arrayOfStrings = Arrays.copyOf(arrayOfStrings, arrayOfStrings.length);
    this.collectionOfString = new ArrayList<>(collectionOfString);
  }

  public long getId() {
    return id;
  }

  public String[] getArrayOfStrings() {
    return Arrays.copyOf(arrayOfStrings, arrayOfStrings.length);
  }

  public Collection<String> getCollectionOfString() {
    return Collections.unmodifiableCollection(collectionOfString);
  }
}
