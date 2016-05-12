package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Usuario;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class UsuarioJpaTest extends JpaEntityManager {

  @Test
  public void adicionaUsuario() {
    final Usuario usuario = new Usuario();
    usuario.setEmail("contato@k19.com.br");
    usuario.setDataDeCadastro(Calendar.getInstance());

    JpaEntityManager.manager.persist(usuario);

    final Usuario resultado = JpaEntityManager.manager.find(Usuario.class,
        usuario.getId());

    assertEquals(resultado, usuario);
  }
}
