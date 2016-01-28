package br.com.k19.controllers;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@WebServlet("*.k19")
public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(final HttpServletRequest req, final HttpServletResponse res)
      throws ServletException, IOException {
    final String[] split = req.getRequestURI().split("/");

    final String controllerName = split[2];
    final String actionName = split[3].split("\\.")[0];

    System.out.println(controllerName);
    System.out.println(actionName);

    try {
      final Class<?> controllerClass = Class.forName("br.com.k19.controllers." + controllerName);
      final Method method = controllerClass.getDeclaredMethod(actionName);

      final Object controller = controllerClass.newInstance();
      method.invoke(controller);

      final RequestDispatcher dispatcher = req.getRequestDispatcher("/" + controllerName + "/" + actionName + ".jsp");
      dispatcher.forward(req, res);
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
