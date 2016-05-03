package com.github.mdssjc.k19.jpa.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Usuario;

public class AdicionaUsuario {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Usuario usuario = new Usuario();
    usuario.setEmail("contato@k19.com.br");
    usuario.setDataDeCadastro(Calendar.getInstance());

    manager.persist(usuario);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
