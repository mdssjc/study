package com.github.mdssjc.fj21_jdbc.jdbc.connection;

import java.sql.Connection;

public interface ConnectionFactory {

  Connection getConnection();
}
