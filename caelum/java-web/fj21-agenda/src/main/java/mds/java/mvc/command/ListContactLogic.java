package mds.java.mvc.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mds.java.persistence.ContatoDAO;

public class ListContactLogic implements LogicCommand {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        Connection connection = (Connection) request.getAttribute("connection");
        request.setAttribute("contatos", new ContatoDAO(connection).getList());

        System.out.println("Listando contatos...");

        return "/WEB-INF/jsp/list-contacts.jsp";
    }
}
