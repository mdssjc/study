package com.github.mdssjc.fj21_agenda.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL implements ConnectionFactory {

  private static final String URL = "jdbc:mysql://localhost:3306/fj21";
  private static final String USER = "dummy";
  private static final String PASS = "dummy";

  @Override
  public Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
