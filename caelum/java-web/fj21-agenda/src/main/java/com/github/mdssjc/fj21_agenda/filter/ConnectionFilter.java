package com.github.mdssjc.fj21_agenda.filter;

import com.github.mdssjc.fj21_agenda.persistence.connection.ConnectionMySQL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter( "/*" )
public class ConnectionFilter implements javax.servlet.Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain)
      throws IOException, ServletException {
    try {
      Connection connection = new ConnectionMySQL().getConnection();

      request.setAttribute("connection", connection);

      chain.doFilter(request, response);

      connection.close();
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
  }
}
