package mds.java.persistence.connection;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection getConnection();
}
