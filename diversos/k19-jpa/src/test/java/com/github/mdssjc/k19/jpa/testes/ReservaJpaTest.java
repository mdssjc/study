package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Reserva;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class ReservaJpaTest extends JpaEntityManager {

  @Test
  public void adicionaReserva() {
    final Reserva reserva = new Reserva();
    reserva.setInicio(LocalDate.of(2015, Month.AUGUST, 3));
    reserva.setTermino(LocalDate.of(2015, Month.AUGUST, 14));

    JpaEntityManager.manager.persist(reserva);

    final Reserva resultado = JpaEntityManager.manager.find(Reserva.class,
        reserva.getId());

    assertEquals(resultado, reserva);
  }
}
