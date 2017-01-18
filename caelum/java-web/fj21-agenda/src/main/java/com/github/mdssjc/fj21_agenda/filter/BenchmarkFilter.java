package com.github.mdssjc.fj21_agenda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter( "/*" )
public class BenchmarkFilter implements javax.servlet.Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain)
      throws IOException, ServletException {
    long start = System.currentTimeMillis();

    chain.doFilter(request, response);

    long stop = System.currentTimeMillis();

    System.out.println("Tempo da requisição (ms): " + (stop - start));
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
  }
}
