package mds.java.mvc.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mds.java.persistence.ContatoDAO;

public class UpdateContactLogic implements LogicCommand {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        Connection connection = (Connection) request.getAttribute("connection");
        Long id = Long.parseLong(request.getParameter("id"));

        request.setAttribute("contato", new ContatoDAO(connection).findById(id));

        System.out.println("Recuperando o contato para atualizar.");

        return "index.jsp";
    }
}
