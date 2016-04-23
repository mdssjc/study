package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

public class UsuarioDaoTest {

  @Test
  public void deveEncontrarPeloNomeEEmailMockado() {
    final Session session = new CriadorDeSessao().getSession();
    final UsuarioDao usuarioDao = new UsuarioDao(session);

    final Usuario usuario = usuarioDao.porNomeEEmail("João da Silva",
        "joao@dasilva.com.br");

    assertEquals("João da Silva", usuario.getNome());
    assertEquals("joao@dasilva.com.br", usuario.getEmail());
  }
}
