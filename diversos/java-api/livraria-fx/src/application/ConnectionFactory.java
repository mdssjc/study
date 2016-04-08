package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public Connection getConnection() {
    final String url = "jdbc:mysql://localhost/livraria";
    try {
      return DriverManager.getConnection(url, "root", "12345");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws SQLException {
    Connection conn = new ConnectionFactory().getConnection();
    System.out.println("Conexão aberta, e agora?");
    conn.close();
  }
}
