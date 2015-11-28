package mds.java.mvc.command;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mds.java.entity.Contato;
import mds.java.persistence.ContatoDAO;
import mds.java.persistence.DAO;

public class SaveContactLogic implements LogicCommand {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            throw e;
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);

        Connection connection = (Connection) request.getAttribute("connection");
        DAO<Contato> dao = new ContatoDAO(connection);
        if (id == null) {
            // add
            dao.save(contato);
            System.out.println("Contato adicionado.");
        } else {
            // update
            contato.setId(Long.parseLong(id));
            dao.set(contato);
            System.out.println("Contato atualizado.");
        }

        return "contato-adicionado.jsp";
    }
}
