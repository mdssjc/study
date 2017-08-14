package com.github.mdssjc.matchmaking;

import java.lang.reflect.Proxy;
import java.util.Hashtable;

public class MatchMakingTestDrive {

  private final Hashtable datingDB = new Hashtable();

  public MatchMakingTestDrive() {
    initializeDatabase();
  }

  public static void main(final String[] args) {
    final MatchMakingTestDrive test = new MatchMakingTestDrive();
    test.drive();
  }

  public void drive() {
    final PersonBean joe = getPersonFromDatabase("Joe Javabean");

    final PersonBean ownerProxy = getOwnerProxy(joe);
    System.out.println("Name is " + ownerProxy.getName());
    ownerProxy.setInterests("bowling, Go");
    System.out.println("Interests set from owner proxy");
    try {
      ownerProxy.setHotOrNotRating(10);
    } catch (final Exception e) {
      System.out.println("Can't set rating from owner proxy");
    }
    System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

    final PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
    System.out.println("Name is " + nonOwnerProxy.getName());
    try {
      nonOwnerProxy.setInterests("bowling, Go");
    } catch (final Exception e) {
      System.out.println("Can't set interests from non owner proxy");
    }
    nonOwnerProxy.setHotOrNotRating(3);
    System.out.println("Rating set from non owner proxy");
    System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
  }

  private PersonBean getOwnerProxy(final PersonBean person) {
    return (PersonBean) Proxy.newProxyInstance(
        person.getClass()
              .getClassLoader(),
        person.getClass()
              .getInterfaces(),
        new OwnerInvocationHandler(person));
  }

  private PersonBean getNonOwnerProxy(final PersonBean person) {
    return (PersonBean) Proxy.newProxyInstance(
        person.getClass()
              .getClassLoader(),
        person.getClass()
              .getInterfaces(),
        new NonOwnerInvocationHandler(person));
  }

  private PersonBean getPersonFromDatabase(final String name) {
    return (PersonBean) this.datingDB.get(name);
  }

  private void initializeDatabase() {
    final PersonBean joe = new PersonBeanImpl();
    joe.setName("Joe Javabean");
    joe.setInterests("cars, computers, music");
    joe.setHotOrNotRating(7);
    this.datingDB.put(joe.getName(), joe);

    final PersonBean kelly = new PersonBeanImpl();
    kelly.setName("Kelly Klosure");
    kelly.setInterests("ebay, movies, music");
    kelly.setHotOrNotRating(6);
    this.datingDB.put(kelly.getName(), kelly);
  }
}
