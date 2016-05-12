package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Candidato;
import com.github.mdssjc.k19.jpa.modelo.Endereco;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class CandidatoJpaTest extends JpaEntityManager {

  @Test
  public void adicionaCandidatoEndereco() {
    final Endereco endereco = new Endereco();
    endereco.setEstado("São Paulo");
    endereco.setCidade("São Paulo");
    endereco.setLogradouro("Av. Brigadeiro Faria Lima");
    endereco.setNumero(1571);

    final Candidato candidato = new Candidato();
    candidato.setNome("Rafael Cosentino");
    candidato.setNascimento(new GregorianCalendar(1984, 10, 30));
    candidato.setEndereco(endereco);

    JpaEntityManager.manager.persist(candidato);

    final Candidato resultado = JpaEntityManager.manager.find(Candidato.class,
        candidato.getId());

    assertEquals(resultado, candidato);
  }
}
