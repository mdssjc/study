package com.github.mdssjc.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL implements ConnectionFactory {

  private static final String URL = "jdbc:mysql://localhost/fj21";
  private static final String USER = "dummy";
  private static final String PASS = "dummy";

  @Override
  public Connection getConnection() {
    try {
      return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
