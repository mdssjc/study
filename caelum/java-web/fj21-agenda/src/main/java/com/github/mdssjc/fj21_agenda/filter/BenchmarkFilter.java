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
  public void doFilter(final ServletRequest request, final ServletResponse response,
                       final FilterChain chain)
      throws IOException, ServletException {
    final long start = System.currentTimeMillis();

    chain.doFilter(request, response);

    final long stop = System.currentTimeMillis();

    System.out.println("Tempo da requisição (ms): " + (stop - start));
  }

  @Override
  public void init(final FilterConfig config) throws ServletException {
  }
}
