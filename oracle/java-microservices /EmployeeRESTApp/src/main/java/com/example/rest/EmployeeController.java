/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeDAO edao = new EmployeeListDAO();

  // Get all employees
  @RequestMapping(method = RequestMethod.GET)
  public Employee[] getAll() {
    return this.edao.getAllEmployees()
                    .toArray(new Employee[0]);
  }

  // Get an employee
  @RequestMapping(method = RequestMethod.GET, value = "{id}")
  public ResponseEntity get(@PathVariable final long id) {
    final Employee match;
    match = this.edao.getEmployee(id);

    if (match != null) {
      return new ResponseEntity<>(match, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  // Get employees by lastName (Week 2)
  @RequestMapping(method = RequestMethod.GET, value = "/lastname/{name}")
  public ResponseEntity getByLastName(@PathVariable final String name) {
    final List<Employee> matches = this.edao.getByLastName(name);

    if (matches != null) {
      return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  // Get employee by title (Week 2)
  @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
  public ResponseEntity getByTitle(@PathVariable final String title) {
    final List<Employee> matches = this.edao.getByTitle(title);

    if (matches != null) {
      return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  // Get employee by dept (Week 2)
  @RequestMapping(method = RequestMethod.GET, value = "/department/{dept}")
  public ResponseEntity getByDept(@PathVariable final String dept) {
    final List<Employee> matches = this.edao.getByDept(dept);

    if (matches != null) {
      return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    return new ResponseEntity(null, HttpStatus.NOT_FOUND);
  }

  // Add an employee
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity add(@RequestBody final Employee employee) {
    if (this.edao.add(employee)) {
      return new ResponseEntity<>(null, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Update an employee
  @RequestMapping(method = RequestMethod.PUT, value = "{id}")
  public ResponseEntity update(@PathVariable final long id, @RequestBody final Employee employee) {
    if (this.edao.update(id, employee)) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  // Delete a employee (Week 3)
  @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
  public ResponseEntity delete(@PathVariable final long id) {
    final boolean isDelete = this.edao.delete(id);
    if (isDelete) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }
}
