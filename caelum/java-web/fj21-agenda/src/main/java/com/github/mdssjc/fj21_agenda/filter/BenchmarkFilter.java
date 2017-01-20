package com.github.mdssjc.fj21_agenda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class BenchmarkFilter implements javax.servlet.Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
                       final FilterChain chain) throws IOException, ServletException {
    final long start = System.currentTimeMillis();

    chain.doFilter(request, response);

    final long stop = System.currentTimeMillis();

    final String uri = ((HttpServletRequest) request).getRequestURI();
    final Optional<String> parameters = Optional.ofNullable(request.getParameter("cmd"));
    System.out.printf("Tempo da requisição de %s%s demorou %d ms%n",
                      uri,
                      parameters.map(x -> "?cmd=" + x)
                                .orElse(""),
                      (stop - start));
  }

  @Override
  public void init(final FilterConfig config) throws ServletException {
  }
}
