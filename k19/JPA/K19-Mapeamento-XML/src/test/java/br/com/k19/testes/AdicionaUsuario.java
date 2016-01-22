package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Usuario;

public class AdicionaUsuario {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_mapeamento_xml_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Usuario usuario = new Usuario();
    usuario.setEmail("contato@k19.com.br");
    usuario.setDataDeCadastro(Calendar.getInstance());

    manager.persist(usuario);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
