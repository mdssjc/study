package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

public class UsuarioDaoTest {

  @Test
  public void deveEncontrarPeloNomeEEmailMockado() {
    final Session session = mock(Session.class);
    final Query query = mock(Query.class);
    final UsuarioDao usuarioDao = new UsuarioDao(session);

    final Usuario usuario = new Usuario("João da Silva", "joao@dasilva.com.br");
    final String sql = "from Usuario u where u.nome = :nome and u.email = :email";

    when(session.createQuery(sql)).thenReturn(query);
    when(query.uniqueResult()).thenReturn(usuario);
    when(query.setParameter("nome", "João da Silva")).thenReturn(query);
    when(query.setParameter("email", "joao@dasilva.com.br")).thenReturn(query);

    final Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("João da Silva",
        "joao@dasilva.com.br");

    assertEquals(usuario.getNome(), usuarioDoBanco.getNome());
    assertEquals(usuario.getEmail(), usuarioDoBanco.getEmail());
  }
}
