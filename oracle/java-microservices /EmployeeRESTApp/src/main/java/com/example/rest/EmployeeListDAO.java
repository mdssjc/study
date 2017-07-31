/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example.rest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class EmployeeListDAO implements EmployeeDAO {

  private final CopyOnWriteArrayList<Employee> eList;

  public EmployeeListDAO() {
    this.eList = MockEmployeeList.getInstance();
  }

  @Override
  public List<Employee> getAllEmployees() {
    return this.eList;
  }

  @Override
  public Employee getEmployee(final long id) {
    Employee match = null;
    match = this.eList.stream()
                      .filter(e -> e.getId() == id)
                      .findFirst()
                      .orElse(match);
    return match;
  }

  @Override
  public List<Employee> getByLastName(final String name) {
    return this.eList.stream()
                     .filter((e) -> (e.getLastName()
                                      .contains(name)))
                     .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getByTitle(final String title) {
    return this.eList.stream()
                     .filter((e) -> (e.getTitle()
                                      .contains(title)))
                     .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getByDept(final String dept) {
    return this.eList.stream()
                     .filter((e) -> (e.getDept()
                                      .contains(dept)))
                     .collect(Collectors.toList());
  }

  @Override
  public boolean add(final Employee employee) {
    final long next = this.eList.size() + 100;
    final Employee nextEmployee =
        new Employee(next, employee.getFirstName(), employee.getLastName(),
                     employee.getEmail(), employee.getPhone(),
                     employee.getBirthDate(), employee.getTitle(),
                     employee.getDept());

    this.eList.add(nextEmployee);
    return true;
  }

  @Override
  public boolean update(final long id, final Employee employee) {
    int matchIndex = -1;
    matchIndex = this.eList.stream()
                           .filter(e -> e.getId() == id)
                           .findFirst()
                           .map(this.eList::indexOf)
                           .orElse(matchIndex);
    if (matchIndex > -1) {
      this.eList.set(matchIndex, employee);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean delete(final long id) {
    int matchIndex = -1;
    matchIndex = this.eList.stream()
                           .filter(e -> e.getId() == id)
                           .findFirst()
                           .map(this.eList::indexOf)
                           .orElse(matchIndex);
    if (matchIndex > -1) {
      this.eList.remove(matchIndex);
      return true;
    } else {
      return false;
    }
  }
}
