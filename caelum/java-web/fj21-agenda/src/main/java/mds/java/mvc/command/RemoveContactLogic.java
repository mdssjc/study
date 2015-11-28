package mds.java.mvc.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mds.java.entity.Contato;
import mds.java.persistence.ContatoDAO;

public class RemoveContactLogic implements LogicCommand {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        Connection connection = (Connection) request.getAttribute("connection");
        long id = Long.parseLong(request.getParameter("id"));

        Contato contact = new Contato();
        contact.setId(id);
        new ContatoDAO(connection).delete(contact);

        System.out.println("Excluindo contato... ");

        return "do?cmd=ListContactLogic";
    }
}
