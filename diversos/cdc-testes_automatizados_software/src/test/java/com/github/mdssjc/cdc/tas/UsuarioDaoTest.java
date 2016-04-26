package com.github.mdssjc.cdc.tas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDaoTest {

  private Session    session;
  private UsuarioDao usuarioDao;

  @Before
  public void inicializacao() {
    this.session = new CriadorDeSessao().getSession();
    this.usuarioDao = new UsuarioDao(this.session);
  }

  public void finalizacao() {
    this.session.close();
  }

  @Test
  public void deveEncontrarPeloNomeEEmail() {
    final Usuario novoUsuario = new Usuario("João da Silva",
        "joao@dasilva.com.br");

    this.usuarioDao.salvar(novoUsuario);

    final Usuario usuario = this.usuarioDao.porNomeEEmail("João da Silva",
        "joao@dasilva.com.br");

    assertEquals("João da Silva", usuario.getNome());
    assertEquals("joao@dasilva.com.br", usuario.getEmail());
  }

  @Test
  public void deveDeletarUmUsuario() {
    final Usuario usuario = new Usuario("Mauricio Aniche",
        "mauricio@aniche.com.br");

    this.usuarioDao.salvar(usuario);
    this.usuarioDao.deletar(usuario);
    this.session.flush();

    final Usuario usuarioNoBanco = this.usuarioDao.porNomeEEmail(
        "Mauricio Aniche", "mauricio@aniche.com.br");

    assertNull(usuarioNoBanco);
  }

  @Test
  public void deveRetornarNuloSeNaoEncontrarUsuario() {
    final Usuario usuarioDoBanco = this.usuarioDao.porNomeEEmail("João Joaquim",
        "joao@joaquim.com.br");

    assertNull(usuarioDoBanco);
  }
}
