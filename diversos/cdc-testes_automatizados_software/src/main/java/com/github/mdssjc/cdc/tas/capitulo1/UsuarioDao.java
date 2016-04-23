package com.github.mdssjc.cdc.tas.capitulo1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDao {

  private final Session session;

  public UsuarioDao(final Session session) {
    this.session = session;
  }

  public Usuario porId(final int id) {
    return (Usuario) this.session.load(Usuario.class, id);
  }

  public Usuario porNomeEEmail(final String nome, final String email) {
    return (Usuario) this.session.createQuery(
        "from Usuario u where u.nome = :nome and u.email = :email")
                                 .setParameter("nome", nome)
                                 .setParameter("email", email)
                                 .uniqueResult();
  }

  public void salvar(final Usuario usuario) {
    final Transaction tx = this.session.beginTransaction();
    this.session.save(usuario);
    tx.commit();
  }
}
