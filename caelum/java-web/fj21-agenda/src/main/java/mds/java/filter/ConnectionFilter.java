package mds.java.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import mds.java.persistence.connection.ConnectionMySQL;

@WebFilter("/*")
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
