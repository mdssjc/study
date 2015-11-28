package mds.java.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
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
