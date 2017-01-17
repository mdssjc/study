package com.github.mdssjc.jdbc.connection;

import java.sql.Connection;

public interface ConnectionFactory {

  Connection getConnection();
}
