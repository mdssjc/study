package com.github.mdssjc.fj21_agenda.persistence.connection;

import java.sql.Connection;

public interface ConnectionFactory {

  Connection getConnection();
}
