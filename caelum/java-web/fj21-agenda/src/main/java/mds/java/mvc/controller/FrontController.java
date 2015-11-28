package mds.java.mvc.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mds.java.mvc.command.LogicCommand;

@WebServlet("/do")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FrontController() {
	super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Optional<String> parameter = Optional.ofNullable(request.getParameter("cmd"));
	String className = "mds.java.mvc.command." + parameter.orElse("NullLogic");

	try {
	    LogicCommand logic = (LogicCommand) Class.forName(className).newInstance();
	    String page = logic.execute(request, response);

	    request.getRequestDispatcher(page).forward(request, response);
	} catch (Exception e) {
	    throw new ServletException(e);
	}
    }
}
